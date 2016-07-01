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

import com.sun.org.apache.regexp.internal.recompile;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String brief;
	private float price;
	private String type;
	@ManyToOne(targetEntity = Restaurant.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "restaurantid")
	private Restaurant restaurant;
	@ManyToOne(targetEntity = Menu.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "pid")
	private Menu menu;
	private String remark;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int id, String name, String brief, float price, String type, Restaurant restaurant, Menu menu,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.brief = brief;
		this.price = price;
		this.type = type;
		this.restaurant = restaurant;
		this.menu = menu;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
