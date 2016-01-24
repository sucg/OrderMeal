package com.glodon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderinfo")
public class Orderinfo implements Serializable {

	// close代表关闭，不可以编辑，open代表开放，可以编辑
	//public static final int CLOSE = 0, OPEN = 1;
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	@ManyToOne(targetEntity = Menu.class, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "menuid")
	private Menu menu;
	@ManyToOne(targetEntity = Userinfo.class, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "userinfoid")
	private Userinfo userinfo;
	private int state;
	private int number;
	private Date date;

	public Orderinfo() {
		// TODO Auto-generated constructor stub
	}
	
	public Orderinfo(int id, String description, Menu menu, Userinfo userinfo,
			int state, int number) {
		super();
		this.id = id;
		this.description = description;
		this.menu = menu;
		this.userinfo = userinfo;
		this.state = state;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
