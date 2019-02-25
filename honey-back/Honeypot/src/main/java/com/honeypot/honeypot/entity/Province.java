package com.honeypot.honeypot.entity;

public class Province {
	
	private Integer id;
	private String  name;
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
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public Province(Integer id, String name, Integer provinceId, String keys) {
		super();
		this.id = id;
		this.name = name;
		this.keys = keys;
	}
	
	public Province() {
		// TODO Auto-generated constructor stub
	}

}
