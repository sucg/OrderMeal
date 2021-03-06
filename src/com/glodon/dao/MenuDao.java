package com.glodon.dao;

import java.io.Serializable;
import java.util.List;

import com.glodon.dao.MenuDao;
import com.glodon.model.Menu;
import com.glodon.model.Page;
import com.glodon.utils.DBConsts;

public class MenuDao extends BaseDao<Menu>{

	public MenuDao() {
	}

	public Menu findByID(Serializable id) {
		return super.findByID(Menu.class, id);
	};

	public List<Menu> findByExampleByPage(Menu example, int nowPage,
			int pageSize, String orderFieldNam, String groupFieldName) {
		return this.findByExampleByPageInnerUse(Menu.class, example, new Page(
				nowPage, pageSize), orderFieldNam, groupFieldName);
	}

	public List<Menu> findByExample(Menu example, String orderFieldName,
			String groupFieldName) {
		return this.findByExampleByPageInnerUse(Menu.class, example, null,
				orderFieldName, groupFieldName);
	}

	@Override
	public String getEntityName() {
		return DBConsts.ptnMenu;
	}

}
