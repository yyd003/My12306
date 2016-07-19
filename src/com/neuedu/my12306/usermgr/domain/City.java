package com.neuedu.my12306.usermgr.domain;

public class City {
	private Province provience;
	private Integer id;
	private String cityid;
	private Integer father;
	private String city;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityId() {
		return cityid;
	}
	public void setCityId(String cityid) {
		this.cityid = cityid;
	}
	public Integer getFather() {
		return father;
	}
	public void setFather(Integer father) {
		this.father = father;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Province getProvience() {
		return provience;
	}
	public void setProvience(Province provience) {
		this.provience = provience;
	}
}
