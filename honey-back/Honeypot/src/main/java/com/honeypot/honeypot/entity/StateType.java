package com.honeypot.honeypot.entity;

public class StateType {
	
	private Integer id;
	private String stateName;
	private String stateLabel;
	
	public String getStateLabel() {
		return stateLabel;
	}
	public void setStateLabel(String stateLabel) {
		this.stateLabel = stateLabel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	public StateType(Integer id, String stateName, String stateLabel) {
		super();
		this.id = id;
		this.stateName = stateName;
		this.stateLabel = stateLabel;
	}
	public StateType() {
		// TODO Auto-generated constructor stub
	}
	
}
