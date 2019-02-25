package com.honeypot.honeypot.entity;

public class ModelUtil {
    private int index;
    private Integer id;
    private String name;
    private String type;
    private String ip;
    private String server;
    private String serverId;
    private String serverIp;

    public ModelUtil(int index, Integer id, String name, String type, String ip, String server, String serverId, String serverIp) {
        this.index = index;
        this.id = id;
        this.name = name;
        this.type = type;
        this.ip = ip;
        this.server = server;
        this.serverId = serverId;
        this.serverIp = serverIp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}
