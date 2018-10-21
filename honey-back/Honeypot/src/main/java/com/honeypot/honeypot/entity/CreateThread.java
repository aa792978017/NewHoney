package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class CreateThread {
    private Integer id;
    private Integer uniqueId;
    private Integer currentProcessID;
    private String currentProcessName;
    private String threadHandle;
    private Integer targetProcessID;
    private String targetProcessName;
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

    public String getThreadHandle() {
        return threadHandle;
    }

    public void setThreadHandle(String threadHandle) {
        this.threadHandle = threadHandle;
    }

    public Integer getTargetProcessID() {
        return targetProcessID;
    }

    public void setTargetProcessID(Integer targetProcessID) {
        this.targetProcessID = targetProcessID;
    }

    public String getTargetProcessName() {
        return targetProcessName;
    }

    public void setTargetProcessName(String targetProcessName) {
        this.targetProcessName = targetProcessName;
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
        CreateThread that = (CreateThread) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uniqueId, that.uniqueId) &&
                Objects.equals(currentProcessID, that.currentProcessID) &&
                Objects.equals(currentProcessName, that.currentProcessName) &&
                Objects.equals(threadHandle, that.threadHandle) &&
                Objects.equals(targetProcessID, that.targetProcessID) &&
                Objects.equals(targetProcessName, that.targetProcessName) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uniqueId, currentProcessID, currentProcessName, threadHandle, targetProcessID, targetProcessName, time);
    }

    @Override
    public String toString() {
        return "CreateThread{" +
                "id=" + id +
                ", uniqueId=" + uniqueId +
                ", currentProcessID=" + currentProcessID +
                ", currentProcessName='" + currentProcessName + '\'' +
                ", threadHandle='" + threadHandle + '\'' +
                ", targetProcessID=" + targetProcessID +
                ", targetProcessName='" + targetProcessName + '\'' +
                ", time=" + time +
                '}';
    }
}
