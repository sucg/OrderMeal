package com.glodon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.glodon.service.MenuManageService;
import com.glodon.service.OrderMealService;

@Controller
public class BaseController {
	
//	@Autowired
//	private OrderMealService orderMealService;
//	
	@Autowired
	private OrderMealService orderMealService;
	
//	@Autowired
//	private UserinfoManageService userinfoManageService;
	
	@Autowired
	private MenuManageService menuManageService;
	
	
	public BaseController() {
		System.out.println("BaseController");
	}


	public MenuManageService getMenuManageService() {
		return menuManageService;
	}


	public void setMenuManageService(MenuManageService menuManageService) {
		this.menuManageService = menuManageService;
	}


	public OrderMealService getOrderMealService() {
		return orderMealService;
	}


	public void setOrderMealService(OrderMealService orderMealService) {
		this.orderMealService = orderMealService;
	}
	
}
