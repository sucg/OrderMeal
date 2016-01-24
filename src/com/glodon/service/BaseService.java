package com.glodon.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.glodon.dao.MenuDao;
import com.glodon.dao.OrderinfoDao;

public class BaseService {
	
	@Autowired
	private MenuDao menuDao;
//	@Autowired
//	private UserinfoDao userinfoDao;
	@Autowired
	private OrderinfoDao orderinfoDao;
	
	public BaseService() {
		System.out.println("BaseService" + this.hashCode());
	}
	public MenuDao getMenuDao() {
		return menuDao;
	}
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	public OrderinfoDao getOrderinfoDao() {
		return orderinfoDao;
	}
	public void setOrderinfoDao(OrderinfoDao orderinfoDao) {
		this.orderinfoDao = orderinfoDao;
	}

}
