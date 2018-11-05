package com.honeypot.honeypot.entity;

public class City {
	
	private Integer id;
	private String  name;
	private Integer provinceId;
	private String keys;
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
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public City(Integer id, String name, Integer provinceId, String keys) {
		super();
		this.id = id;
		this.name = name;
		this.provinceId = provinceId;
		this.keys = keys;
	}
	
	public City() {
		// TODO Auto-generated constructor stub
	}

}
