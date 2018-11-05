package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class PendingThread {
    private Integer id;
    private Integer CurrentProcessId;
    private String CurrentProcessName;
    private String PendingProcessID;
    private String DependProcessID;
    private Date Time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentProcessId() {
        return CurrentProcessId;
    }

    public void setCurrentProcessId(Integer currentProcessId) {
        CurrentProcessId = currentProcessId;
    }

    public String getCurrentProcessName() {
        return CurrentProcessName;
    }

    public void setCurrentProcessName(String currentProcessName) {
        CurrentProcessName = currentProcessName;
    }

    public String getPendingProcessID() {
        return PendingProcessID;
    }

    public void setPendingProcessID(String pendingProcessID) {
        PendingProcessID = pendingProcessID;
    }

    public String getDependProcessID() {
        return DependProcessID;
    }

    public void setDependProcessID(String dependProcessID) {
        DependProcessID = dependProcessID;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PendingThread that = (PendingThread) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(CurrentProcessId, that.CurrentProcessId) &&
                Objects.equals(CurrentProcessName, that.CurrentProcessName) &&
                Objects.equals(PendingProcessID, that.PendingProcessID) &&
                Objects.equals(DependProcessID, that.DependProcessID) &&
                Objects.equals(Time, that.Time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, CurrentProcessId, CurrentProcessName, PendingProcessID, DependProcessID, Time);
    }

    @Override
    public String toString() {
        return "PendingThread{" +
                "id=" + id +
                ", CurrentProcessId=" + CurrentProcessId +
                ", CurrentProcessName='" + CurrentProcessName + '\'' +
                ", PendingProcessID='" + PendingProcessID + '\'' +
                ", DependProcessID='" + DependProcessID + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
