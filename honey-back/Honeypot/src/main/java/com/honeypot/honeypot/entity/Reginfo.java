package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

//注册表基本信息实体类
public class Reginfo {
    private Integer id ;
    private Integer uniqueId;
    private Integer processId;
    private String processName;
    private String regPath;
    private Integer opType;
    private Date time;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRegPath() {
        return regPath;
    }

    public void setRegPath(String regPath) {
        this.regPath = regPath;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reginfo reginfo = (Reginfo) o;
        return Objects.equals(id, reginfo.id) &&
                Objects.equals(uniqueId, reginfo.uniqueId) &&
                Objects.equals(processId, reginfo.processId) &&
                Objects.equals(processName, reginfo.processName) &&
                Objects.equals(regPath, reginfo.regPath) &&
                Objects.equals(opType, reginfo.opType) &&
                Objects.equals(time, reginfo.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uniqueId, processId, processName, regPath, opType, time);
    }
    @Override
    public String toString() {
        return "Reginfo{" +
                "id=" + id +
                ", uniqueId=" + uniqueId +
                ", processId=" + processId +
                ", processName='" + processName + '\'' +
                ", regPath='" + regPath + '\'' +
                ", opType=" + opType +
                ", time=" + time +
                '}';
    }
}
