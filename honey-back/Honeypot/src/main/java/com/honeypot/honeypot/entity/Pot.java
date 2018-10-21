package com.honeypot.honeypot.entity;

/**
 * Created by xiejing on 18/4/12.
 */
public class Pot {
    private int id;
    private String ip;
    private String type;
    private String cpu;
    private String memory;
    private String disk;
    private String server;
    private Integer serverId;
    private String uniqueId;
    private String domainId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getUniqueId(){return uniqueId;}

    public void setUniqueId(String uniqueId){this.uniqueId =uniqueId;}

    public String getDomainId(){return domainId;}

    public void setDomainId(String domainId) { this.domainId = domainId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pot pot = (Pot) o;

        if (id != pot.id) return false;
        if (ip != null ? !ip.equals(pot.ip) : pot.ip != null) return false;
        if (type != null ? !type.equals(pot.type) : pot.type != null) return false;
        if (cpu != null ? !cpu.equals(pot.cpu) : pot.cpu != null) return false;
        if (memory != null ? !memory.equals(pot.memory) : pot.memory != null) return false;
        if (disk != null ? !disk.equals(pot.disk) : pot.disk != null) return false;
        if (server != null ? !server.equals(pot.server) : pot.server != null) return false;
        if (serverId != null ? !serverId.equals(pot.serverId) : pot.serverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + (memory != null ? memory.hashCode() : 0);
        result = 31 * result + (disk != null ? disk.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (serverId != null ? serverId.hashCode() : 0);
        return result;
    }
}
