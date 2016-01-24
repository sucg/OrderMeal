package com.glodon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glodon.model.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> menuList(Integer page, Integer rows){
		List<Menu> menuList = this.getMenuManageService().showMenuList(page, rows, "");
		Map<String, Object> result = new HashMap<String, Object>();
		Long count = this.getMenuManageService().getMenuCount();
		result.put("rows", menuList);
		result.put("total", count);
		return result;
	}
	
	@RequestMapping("/delete")
	public String deleteMenu(@RequestBody List<Menu> menuList){
		System.out.println(menuList);
		//this.getMenuManageService().deleteMenu(menu);
		return "index";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> updateMenu(@RequestBody Menu menu){
		System.out.println(menu.getDescription());
		System.out.println(menu.getPrice());
		System.out.println(menu.getMenu());
		//this.getMenuManageService().updateMenu(menu);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("value", menu);
		result.put("result", "success");
		return result;
	}
}