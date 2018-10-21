package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class SetRegValueKey {
    private Integer id;
    private Integer uniqueId;
    private Integer processID;
    private String processName;
    private String keyValue;
    private Integer dataType;
    private Integer dataSize;
    private String regPath;
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

    public Integer getProcessID() {
        return processID;
    }

    public void setProcessID(Integer processID) {
        this.processID = processID;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getDataSize() {
        return dataSize;
    }

    public void setDataSize(Integer dataSize) {
        this.dataSize = dataSize;
    }

    public String getRegPath() {
        return regPath;
    }

    public void setRegPath(String regPath) {
        this.regPath = regPath;
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
        SetRegValueKey that = (SetRegValueKey) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uniqueId, that.uniqueId) &&
                Objects.equals(processID, that.processID) &&
                Objects.equals(processName, that.processName) &&
                Objects.equals(keyValue, that.keyValue) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(dataSize, that.dataSize) &&
                Objects.equals(regPath, that.regPath) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uniqueId, processID, processName, keyValue, dataType, dataSize, regPath, time);
    }
    @Override
    public String toString() {
        return "SetRegValueKey{" +
                "id=" + id +
                ", uniqueId=" + uniqueId +
                ", processID=" + processID +
                ", processName='" + processName + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", dataType=" + dataType +
                ", dataSize=" + dataSize +
                ", regPath='" + regPath + '\'' +
                ", time=" + time +
                '}';
    }
}
