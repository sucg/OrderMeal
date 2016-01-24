package com.glodon.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private float price;
	@ManyToOne(targetEntity = Menu.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "pid")
	private Menu menu;
	private String remark;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int id, String description, float price, Menu menu,
			String remark) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.menu = menu;
		this.remark = remark;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
