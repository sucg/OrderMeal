package com.glodon.service;

import java.util.List;

import com.glodon.model.Menu;
import com.glodon.model.Page;
import com.glodon.model.QueryEntity;

public class MenuManageService extends BaseService {

	public MenuManageService() {
		System.out.println("MenuManageService");
	}

	public List<Menu> showMenuList(Integer nowPage, Integer pageSize,
			String orderFieldName, String description) {
		Page page = null;
		if (nowPage != null && pageSize != null && nowPage > 0 && pageSize > 0) {
			page = new Page();
			page.setNowPage(nowPage);
			page.setPageSize(pageSize);
		}
	
		QueryEntity queryEntity = null;
		if (description != null && !description.isEmpty()) {
			queryEntity = new QueryEntity();
			queryEntity.setFieldNames(new String[]{"description"});
			queryEntity.setCaclNames(new String[] { "like" });
			queryEntity.setValues(new String[] {"%" + description + "%"});
		}
		return this.getMenuDao().findByPropertiesByPage(queryEntity, page,
				orderFieldName, "");
	}

	public Long getMenuCount(QueryEntity queryEntity) {
		return this.getMenuDao().getTotlaCount(queryEntity);
	}

	public void deleteMenu(Menu menu) {
		this.getMenuDao().delete(menu);
	}

	public void updateMenu(Menu menu) {
		this.getMenuDao().update(menu);
	}

}
