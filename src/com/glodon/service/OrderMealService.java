package com.glodon.service;

import java.util.List;

import com.glodon.model.Menu;
import com.glodon.model.Orderinfo;
import com.glodon.model.Page;
import com.glodon.model.QueryEntity;

public class OrderMealService extends BaseService {

	public OrderMealService() {
		// TODO Auto-generated constructor stub
	}

	public List<Orderinfo> showOrderinfoList(Integer nowPage, Integer pageSize,
			String orderFieldName) {
		Page page = null;
		if (nowPage != null && pageSize != null && nowPage > 0 && pageSize > 0) {
			page = new Page();
			page.setNowPage(nowPage);
			page.setPageSize(pageSize);
		}
		return this.getOrderinfoDao().findByPropertiesByPage(null, page,
				orderFieldName, "");
	}

	public Long getOrderinfoCount() {
		return this.getOrderinfoDao().getTotlaCount();
	}

	public void deleteOrderinfo(List<Orderinfo> orderinfoList) {
		for (Orderinfo orderinfo : orderinfoList) {
			this.getOrderinfoDao().delete(orderinfo);
		}
	}

	public void updateOrderinfo(Orderinfo orderinfo) {
		this.getOrderinfoDao().update(orderinfo);
	}

	public void addOrderinfo(Orderinfo orderinfo) {
		this.getOrderinfoDao().save(orderinfo);
	}

	public void orderMeal(List<Menu> menuList) {
		for (Menu menu : menuList) {
			Orderinfo orderinfo = new Orderinfo();
			orderinfo.setMenu(menu);
			this.getOrderinfoDao().save(orderinfo);
		}
	}

	public boolean isOrdered(Menu menu) {
		QueryEntity queryEntity = new QueryEntity();
		System.out.println(menu.getId());
		queryEntity.setFieldNames(new String[]{"entity.menu"});
		queryEntity.setCaclNames(new String[]{"="});
		queryEntity.setValues(new Object[]{menu});
		List<Orderinfo> resultSet = this.getOrderinfoDao().findByProperties(
				queryEntity, null, null);
		if (resultSet != null && resultSet.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
