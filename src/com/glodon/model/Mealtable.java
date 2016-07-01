package com.glodon.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mealtable")
public class Mealtable implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String type;
	private Float sum;
	private Float average;
	private Integer peoplenum;
	@ManyToOne(targetEntity = Restaurant.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "restaurantid")
	private Restaurant restaurant;
	// 创建时间
	private Date createdate;
	// 吃饭开始时间
	private Date startdate;
	// 创建人
	@ManyToOne(targetEntity = Userinfo.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userinfoid")
	private Userinfo userinfo;
	// 付款人
	private String payer;
	private String remark;
	// 状态，有正在点餐，餐点完毕，结束三个状态，详细见Constants类
	private String status;

	public Mealtable() {
		// TODO Auto-generated constructor stub
	}

	public Mealtable(Integer id, String name, String type, Float sum, Float average, Integer peoplenum,
			Restaurant restaurant, Date createdate, Date startdate, Userinfo userinfo, String payer, String remark,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.sum = sum;
		this.average = average;
		this.peoplenum = peoplenum;
		this.restaurant = restaurant;
		this.createdate = createdate;
		this.startdate = startdate;
		this.userinfo = userinfo;
		this.payer = payer;
		this.remark = remark;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getSum() {
		return sum;
	}

	public void setSum(Float sum) {
		this.sum = sum;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Integer getPeoplenum() {
		return peoplenum;
	}

	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
