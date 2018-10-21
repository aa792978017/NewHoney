package com.honeypot.honeypot.entity;

import java.util.Objects;

public class NetInfo {
    String ip;
    String domainId;
    String type;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetInfo netInfo = (NetInfo) o;
        return Objects.equals(ip, netInfo.ip) &&
                Objects.equals(domainId, netInfo.domainId) &&
                Objects.equals(type, netInfo.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ip, domainId, type);
    }

    @Override
    public String toString() {
        return "NetInfo{" +
                "ip='" + ip + '\'' +
                ", domainId='" + domainId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
