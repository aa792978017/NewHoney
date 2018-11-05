package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class FileSystemInfo {
        private Integer id;
        private Integer uniqueId;
        private Integer opType;
        private Integer state;
        private Integer removable;
        private String filePath;
        private String processPath;
        private String processName;
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

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRemovable() {
        return removable;
    }

    public void setRemovable(Integer removable) {
        this.removable = removable;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getProcessPath() {
        return processPath;
    }

    public void setProcessPath(String processPath) {
        this.processPath = processPath;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
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
        FileSystemInfo that = (FileSystemInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uniqueId, that.uniqueId) &&
                Objects.equals(opType, that.opType) &&
                Objects.equals(state, that.state) &&
                Objects.equals(removable, that.removable) &&
                Objects.equals(filePath, that.filePath) &&
                Objects.equals(processPath, that.processPath) &&
                Objects.equals(processName, that.processName) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uniqueId, opType, state, removable, filePath, processPath, processName, time);
    }

    @Override
    public String toString() {
        return "FileSystemInfo{" +
                "id=" + id +
                ", uniqueId=" + uniqueId +
                ", opType=" + opType +
                ", state=" + state +
                ", removable=" + removable +
                ", filePath='" + filePath + '\'' +
                ", processPath='" + processPath + '\'' +
                ", processName='" + processName + '\'' +
                ", time=" + time +
                '}';
    }
}


