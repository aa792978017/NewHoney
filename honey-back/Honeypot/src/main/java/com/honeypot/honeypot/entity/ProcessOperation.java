package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class ProcessOperation {
    private Integer id;
    private Integer uniqueId;
    private Integer currentProcessID;
    private String currentProcessName;
    private Integer opType;
    private Integer objectProcessID;
    private String objectProcessName;
    private Date time;

    public String getObjectProcessName() {
        return objectProcessName;
    }

    public void setObjectProcessName(String objectProcessName) {
        this.objectProcessName = objectProcessName;
    }

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

    public Integer getCurrentProcessID() {
        return currentProcessID;
    }

    public void setCurrentProcessID(Integer currentProcessID) {
        this.currentProcessID = currentProcessID;
    }

    public String getCurrentProcessName() {
        return currentProcessName;
    }

    public void setCurrentProcessName(String currentProcessName) {
        this.currentProcessName = currentProcessName;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getObjectProcessID() {
        return objectProcessID;
    }

    public void setObjectProcessID(Integer objectProcessID) {
        this.objectProcessID = objectProcessID;
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
        ProcessOperation that = (ProcessOperation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uniqueId, that.uniqueId) &&
                Objects.equals(currentProcessID, that.currentProcessID) &&
                Objects.equals(currentProcessName, that.currentProcessName) &&
                Objects.equals(opType, that.opType) &&
                Objects.equals(objectProcessID, that.objectProcessID) &&
                Objects.equals(objectProcessName, that.objectProcessName) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uniqueId, currentProcessID, currentProcessName, opType, objectProcessID, objectProcessName, time);
    }

    @Override
    public String toString() {
        return "ProcessOperation{" +
                "id=" + id +
                ", uniqueId=" + uniqueId +
                ", currentProcessID=" + currentProcessID +
                ", currentProcessName='" + currentProcessName + '\'' +
                ", opType=" + opType +
                ", objectProcessID=" + objectProcessID +
                ", objectProcessName='" + objectProcessName + '\'' +
                ", time=" + time +
                '}';
    }
}
