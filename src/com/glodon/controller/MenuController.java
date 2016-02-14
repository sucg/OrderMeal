package com.glodon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glodon.model.Menu;
import com.glodon.model.QueryEntity;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> menuList(Integer page, Integer rows, String description){
		List<Menu> menuList = this.getMenuManageService().showMenuList(page, rows, "", description);
		Map<String, Object> result = new HashMap<String, Object>();
		QueryEntity queryEntity = null;
		if(description != null){
			queryEntity = new QueryEntity();
			queryEntity.setFieldNames(new String[]{"description"});
			queryEntity.setCaclNames(new String[]{"like"});
			queryEntity.setValues(new String[]{"%" + description + "%"});
		}
		Long count = this.getMenuManageService().getMenuCount(queryEntity);
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
