package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class Module {
    private Integer id;
    private Integer opType;
    private Integer processNum;
    private String processName;
    private String regeditName;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRegeditName() {
        return regeditName;
    }

    public void setRegeditName(String regeditName) {
        this.regeditName = regeditName;
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
        Module module = (Module) o;
        return Objects.equals(id, module.id) &&
                Objects.equals(opType, module.opType) &&
                Objects.equals(processNum, module.processNum) &&
                Objects.equals(processName, module.processName) &&
                Objects.equals(regeditName, module.regeditName) &&
                Objects.equals(time, module.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, opType, processNum, processName, regeditName, time);
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", opType=" + opType +
                ", processNum=" + processNum +
                ", processName='" + processName + '\'' +
                ", regeditName='" + regeditName + '\'' +
                ", time=" + time +
                '}';
    }
}
