package com.glodon.dao;

import java.io.Serializable;
import java.util.List;

import com.glodon.model.Menu;
import com.glodon.model.Page;
import com.glodon.model.Userinfo;
import com.glodon.utils.DBConsts;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class UserinfoDao extends BaseDao<Userinfo> {

	public UserinfoDao() {
		System.out.println("UserinfoDao");
	}
	
	public Userinfo findByID(Serializable id) {
		return super.findByID(Userinfo.class, id);
	};
	
	public List<Userinfo> findByExampleByPage(Userinfo example, int nowPage,
			int pageSize, String orderFieldNam, String groupFieldName) {
		return this.findByExampleByPageInnerUse(Menu.class, example, new Page(
				nowPage, pageSize), orderFieldNam, groupFieldName);
	}

	public List<Userinfo> findByExample(Userinfo example, String orderFieldName,
			String groupFieldName) {
		return this.findByExampleByPageInnerUse(Userinfo.class, example, null,
				orderFieldName, groupFieldName);
	}
	
	@Override
	public String getEntityName() {
		return DBConsts.ptnUserinfo;
	}
}
