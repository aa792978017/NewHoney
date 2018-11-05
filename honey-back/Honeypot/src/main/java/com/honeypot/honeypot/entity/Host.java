package com.honeypot.honeypot.entity;

public class Host {
	
	private Integer id;
	private String macAddress;
	private String ip;
	private String hostname;
	private String username;
	private Integer hostType;
	private Integer osType;
	private String cpu;
	private String memory;
	private Integer state;
	private Integer departmentId;
	private String macMd5;
	
	private String company;
	private Integer city;
	private Integer province;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getHostType() {
		return hostType;
	}
	public void setHostType(Integer hostType) {
		this.hostType = hostType;
	}
	public Integer getOsType() {
		return osType;
	}
	public void setOsType(Integer osType) {
		this.osType = osType;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getMacMd5() {
		return macMd5;
	}
	public void setMacMd5(String macMd5) {
		this.macMd5 = macMd5;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Host(Integer id, String macAddress, String ip, String hostname,
			String username, Integer hostType, Integer osType, String cpu,
			String memory, Integer state, Integer departmentId, String macMd5) {
		super();
		this.id = id;
		this.macAddress = macAddress;
		this.ip = ip;
		this.hostname = hostname;
		this.username = username;
		this.hostType = hostType;
		this.osType = osType;
		this.cpu = cpu;
		this.memory = memory;
		this.state = state;
		this.departmentId = departmentId;
		this.macMd5 = macMd5;
	}
	
	public Host(Integer id, String macAddress, String ip, String hostname,
			String username, Integer hostType, Integer osType, String cpu,
			String memory, Integer state, Integer departmentId, String macMd5,
			String company, Integer city, Integer province) {
		super();
		this.id = id;
		this.macAddress = macAddress;
		this.ip = ip;
		this.hostname = hostname;
		this.username = username;
		this.hostType = hostType;
		this.osType = osType;
		this.cpu = cpu;
		this.memory = memory;
		this.state = state;
		this.departmentId = departmentId;
		this.macMd5 = macMd5;
		this.company = company;
		this.city = city;
		this.province = province;
	}
	public Host() {
		// TODO Auto-generated constructor stub
	}


}
