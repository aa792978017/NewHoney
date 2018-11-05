package com.honeypot.honeypot.entity;

public class WarningSum {
	private Integer id;
	private String time;
	private Integer num;
	private Integer flag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public WarningSum(Integer id, String time, Integer num, Integer flag) {
		super();
		this.id = id;
		this.time = time;
		this.num = num;
		this.flag = flag;
	}
	
	public WarningSum() {
		// TODO Auto-generated constructor stub
	}
}
