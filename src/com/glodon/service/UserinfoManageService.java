package com.glodon.service;

import java.util.List;

import com.glodon.model.QueryEntity;
import com.glodon.model.Userinfo;

public class UserinfoManageService extends BaseService {

	public UserinfoManageService() {
		System.out.println("UserinfoManageService");
	}

	public Userinfo login(Userinfo userinfo) {
		QueryEntity queryEntity = new QueryEntity();
		queryEntity.setFieldNames(new String[]{"name", "password"});
		queryEntity.setCaclNames(new String[]{"=", "="});
		queryEntity.setValues(new Object[]{userinfo.getName(), userinfo.getPassword()});
		List<Userinfo> all = this.getUserinfoDao().findByProperties(queryEntity, null, null);
		return all.size() == 1 ? all.get(0) : null; 
	}

	public boolean logout(Userinfo userinfo) {
		userinfo = this.getUserinfoDao().findByID(userinfo.getId());
		if(userinfo == null)
		{
			return true;
		}else {
			return false;
		}
	}
	
	
}
