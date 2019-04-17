package com.baidu.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.test.PageUtil;
import com.baidu.test.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class DepartmentController {

	@Resource
	private DepartmentService ser;
	
	
	
	@RequestMapping( value="list",produces = "application/json; charset=utf-8")
	public String  tolist( String name,HttpServletRequest request,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="3") Integer pageSize)
	{
		PageHelper.startPage(page,pageSize);
		List<Map> list = ser.selectList(name);
		PageInfo<Map> info = new PageInfo<>(list);
		
		
		for (Map map : list) {
			System.out.println(map.toString());
		}
		PageUtil.page(request, "/list?name="+name, pageSize, info.getList(), (int)info.getTotal(), page);
		request.setAttribute("list", info.getList());
		request.setAttribute("name", name);
		request.setAttribute("pageSize", pageSize);
		return "list";
	}
	
	
}
