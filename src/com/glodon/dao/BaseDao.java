package com.glodon.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.glodon.dao.BaseDao;
import com.glodon.model.Page;
import com.glodon.model.QueryEntity;

/**
 * 所有Dao的父类，提供一些底层的通用方法，简化每个子类
 * 
 * @author sucg
 * @date 2016.1.17
 * @param <T>
 */
public class BaseDao<T>{

	@Autowired
	private SessionFactory sessionFactory;

	public BaseDao() {
		System.out.println("BaseDao");
	}

	public void delete(T entity) {
		this.getSessionFactory().getCurrentSession().delete(entity);
	}

	public T save(T entity) {
		return (T) this.getSessionFactory().getCurrentSession().save(entity);
	}

	public void update(T entity) {
		this.getSessionFactory().getCurrentSession().update(entity);
	}

	public List<T> findAll() {
		Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("from " + this.getEntityName()).list();
	}
	
	public List<T> findAll(String orderFieldName, String groupFieldName) {
		return this.findByProperties(null, orderFieldName, groupFieldName);
	}
	
	public List<T> findAllByPage(Page page, String orderFieldName, String groupFieldName) {
		return this.findByPropertiesByPage(null, page, orderFieldName, groupFieldName);
	}

	protected T findByID(Class arg0, Serializable arg1) {
		Session session = this.getSessionFactory().getCurrentSession();
		return (T) session.get(arg0, arg1);
	}

	protected List<T> findByExampleByPageInnerUse(Class c, T example,
			Page page, String orderFieldName, String groupFieldName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = null;
		criteria = session.createCriteria(c).add(Example.create(example));

		if (page != null) {// 进行分页
			criteria.setMaxResults(page.getPageSize()).setFirstResult(
					page.getPageSize() * (page.getNowPage() - 1));
		}

		if (groupFieldName != null && groupFieldName.length() > 0) {// 分组
			if (groupFieldName.contains("group by")) {
				groupFieldName = groupFieldName.replace("group by", "");
			}
			criteria.setProjection(Projections.groupProperty(groupFieldName
					.trim()));
		}

		if (orderFieldName != null && orderFieldName.trim().length() > 0) {// 进行排序
			if (orderFieldName.contains("desc")) {// 倒序
				orderFieldName = orderFieldName.replace("desc", "");
				criteria.addOrder(Order.desc(orderFieldName.trim()));
			} else {
				orderFieldName = orderFieldName.replace("asc", "");
				criteria.addOrder(Order.asc(orderFieldName.trim()));
			}
		}
		return criteria.list();
	}

	public List<T> findByPropertiesByPage(QueryEntity queryEntity, Page page,
			String orderFieldName, String groupFieldName) {
		// HQL
		StringBuffer hql = new StringBuffer();
		hql.append("from " + getEntityName() + " as entity where 1 = 1 ");

		Session session = sessionFactory.getCurrentSession();
		if (session == null)
			return null;

		if (orderFieldName != null && orderFieldName.trim().length() > 0) {// 排序
			if (!orderFieldName.contains("order by")) {
				hql.append(" order by " + orderFieldName.trim());
			} else {
				hql.append(" " + orderFieldName.trim());
			}
		}

		if (groupFieldName != null && groupFieldName.trim().length() > 0) {// 分组
			if (!groupFieldName.contains("group by")) {
				hql.append(" group by " + groupFieldName.trim());
			} else {
				hql.append(" " + groupFieldName.trim());
			}
		}

		int queryParamCount = 0;
		if (queryEntity != null) {
			queryParamCount = queryEntity.getFieldNames().length;
			for (int i = 0; i < queryParamCount; i++) {
				hql.append(" and ");
				hql.append(queryEntity.getFieldNames()[i]+" ");
				hql.append(queryEntity.getCaclNames()[i]+" ");
				hql.append(" ? ");
			}
		}
		System.out.println(hql.toString());
		Query qry = session.createQuery(hql.toString());// 参数设置
		if (queryEntity != null && queryEntity.getValues() != null && queryParamCount > 0) {
			for (int i = 0; i < queryParamCount; i++) {
				qry.setParameter(i, queryEntity.getValues()[i]);
			}
		}

		if (page != null) {// 分页处理
			int start = (page.getNowPage() - 1) * page.getPageSize();
			qry.setFirstResult(start);
			qry.setMaxResults(page.getPageSize());
		}

		return qry.list();
	}

	public List<T> findByProperties(QueryEntity queryEntity,
			String orderFieldName, String groupFieldName) {
		return this.findByPropertiesByPage(queryEntity, null, orderFieldName, groupFieldName);
	}
	
	public Long getTotlaCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Long i = (Long) session.createQuery("select count (*) from " + getEntityName())
				.uniqueResult();
		return i;
	}
	
	public long getTotlaCount(QueryEntity queryEntity) {
		if (queryEntity == null) {
			return getTotlaCount();
		}
		
		Session session = this.sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count (*) from " + getEntityName() +" where 1=1 ");
		for (int i = 0; i < queryEntity.getFieldNames().length; i++) {
				hql.append(" and ");
				hql.append(queryEntity.getFieldNames()[i]+" ");
				hql.append(queryEntity.getCaclNames()[i]+" ");
				hql.append(" ? ");
		}
		System.out.println(hql);
		Query query = session.createQuery(hql.toString());
		for (int i = 0; i < queryEntity.getValues().length; i++) {
			query.setParameter(i, queryEntity.getValues()[i]);
		}
		Long i = (Long) query.uniqueResult();
		return i;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String getEntityName() {
		return "";
	}

}
