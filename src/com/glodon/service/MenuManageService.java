package com.glodon.service;

import java.util.List;

import com.glodon.model.Menu;
import com.glodon.model.Page;

public class MenuManageService extends BaseService {

	public MenuManageService() {
		System.out.println("MenuManageService");
	}
	
	public List<Menu> showMenuList(Integer nowPage, Integer pageSize, String orderFieldName){
		Page page = null;
		if (nowPage != null && pageSize!= null && nowPage > 0 && pageSize > 0) {
			page = new Page();
			page.setNowPage(nowPage);
			page.setPageSize(pageSize);
		}
		return this.getMenuDao().findByPropertiesByPage(null, page, orderFieldName, "");
	}
	
	public Long getMenuCount(){
		return this.getMenuDao().getTotlaCount();
	}

	public void deleteMenu(Menu menu) {
		this.getMenuDao().delete(menu);
	}

	public void updateMenu(Menu menu) {
		this.getMenuDao().update(menu);
	}

}
