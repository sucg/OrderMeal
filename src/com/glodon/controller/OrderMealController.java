package com.glodon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glodon.model.Menu;
import com.glodon.model.Orderinfo;
import com.glodon.model.Userinfo;

@Controller
@RequestMapping("/ordermeal")
public class OrderMealController extends BaseController {

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> showOrderinfo(Integer page, Integer rows) {
		List<Orderinfo> orderinfoList = this.getOrderMealService()
				.showOrderinfoList(page, rows, "");
		Map<String, Object> result = new HashMap<String, Object>();
		Long count = this.getOrderMealService().getOrderinfoCount();
		result.put("rows", orderinfoList);
		result.put("total", count);
		return result;
	}

	@RequestMapping("/order")
	@ResponseBody
	public Map<String, Object> orderMeal(@RequestBody Menu[] menus, HttpSession session) {
		List<Menu> menuList = new ArrayList<Menu>();
		Userinfo userinfo = (Userinfo) session.getAttribute("userinfo");
		StringBuffer message = new StringBuffer(" ");
		boolean isSuccess = true;
		boolean isOrdered = false;
		for (Menu menu : menus) {
			isOrdered = this.getOrderMealService().isOrdered(menu);
			if (isOrdered) {
				isSuccess = false;
				message.append(menu.getDescription() + " ,");
			} else {
				menuList.add(menu);
			}
		}
		
		if (isSuccess) {
			this.getOrderMealService().orderMeal(menuList, userinfo);
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", isSuccess);
		result.put("message", message.substring(0, message.length() - 1));
		System.out.println(menuList);
		// this.getMenuManageService().deleteMenu(menu);
		return result;
	}

	@RequestMapping("/delete")
	public String orderMeal(@RequestBody Orderinfo[] orderinfos) {
		System.out.println(orderinfos);
		List<Orderinfo> orderinfoList = new ArrayList<Orderinfo>();
		for (Orderinfo orderinfo : orderinfos) {
			orderinfoList.add(orderinfo);
		}
		this.getOrderMealService().deleteOrderinfo(orderinfoList);

		// this.getMenuManageService().deleteMenu(menu);
		return "index";
	}

}
