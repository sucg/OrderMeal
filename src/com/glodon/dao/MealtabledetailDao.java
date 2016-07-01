package com.glodon.dao;

import java.io.Serializable;
import java.util.List;

import com.glodon.model.Mealtabledetail;
import com.glodon.model.Page;
import com.glodon.utils.DBConsts;

public class MealtabledetailDao extends BaseDao<Mealtabledetail>{
	
	
	public Mealtabledetail findByID(Serializable id) {
		return super.findByID(Mealtabledetail.class, id);
	};

	public List<Mealtabledetail> findByExampleByPage(Mealtabledetail example, int nowPage,
			int pageSize, String orderFieldNam, String groupFieldName) {
		return this.findByExampleByPageInnerUse(Mealtabledetail.class, example, new Page(
				nowPage, pageSize), orderFieldNam, groupFieldName);
	}

	public List<Mealtabledetail> findByExample(Mealtabledetail example, String orderFieldName,
			String groupFieldName) {
		return this.findByExampleByPageInnerUse(Mealtabledetail.class, example, null,
				orderFieldName, groupFieldName);
	}

	@Override
	public String getEntityName() {
		return DBConsts.ptnMealTableDetail;
	}
	
}
