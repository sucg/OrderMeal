package com.glodon.dao;

import java.io.Serializable;
import java.util.List;

import com.glodon.model.Orderinfo;
import com.glodon.model.Page;

public class OrderinfoDao extends BaseDao<Orderinfo>{
	
	final static String ptnOrderinfo = "Orderinfo";
	
	public OrderinfoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Orderinfo findByID(Serializable id) {
		return super.findByID(Orderinfo.class, id);
	};

	public List<Orderinfo> findByExampleByPage(Orderinfo example, int nowPage,
			int pageSize, String orderFieldNam, String groupFieldName) {
		return this.findByExampleByPageInnerUse(Orderinfo.class, example, new Page(
				nowPage, pageSize), orderFieldNam, groupFieldName);
	}

	public List<Orderinfo> findByExample(Orderinfo example, String orderFieldName,
			String groupFieldName) {
		return this.findByExampleByPageInnerUse(Orderinfo.class, example, null,
				orderFieldName, groupFieldName);
	}

	@Override
	public String getEntityName() {
		return ptnOrderinfo;
	}
	
}
