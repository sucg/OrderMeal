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
@Table(name = "mealtabledetail")
public class Mealtabledetail implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(targetEntity = Mealtable.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "mealtableid")
	private Mealtable mealtable;
	@ManyToOne(targetEntity = Menu.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "menuid")
	private Menu menu;
	@ManyToOne(targetEntity = Userinfo.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "userinfoid")
	private Userinfo userinfo;
	private int number;
	private Date createdate;

	public Mealtabledetail() {
		// TODO Auto-generated constructor stub
	}

	public Mealtabledetail(int id, Mealtable mealtable, Menu menu, Userinfo userinfo, int number, Date createdate) {
		super();
		this.id = id;
		this.mealtable = mealtable;
		this.menu = menu;
		this.userinfo = userinfo;
		this.number = number;
		this.createdate = createdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mealtable getMealtable() {
		return mealtable;
	}

	public void setMealtable(Mealtable mealtable) {
		this.mealtable = mealtable;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
