package com.honeypot.honeypot.entity;

import java.util.Date;
import java.util.Objects;

public class RecoverThread {
    private Integer Id;
    private Integer UniqueId;
    private Integer CurrentProcessID;
    private String CurrentProcessName;
    private String PendingProcessID;
    private String DependProcessID;
    private String DependProcessName;
    private Date Time;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUniqueId() {
        return UniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        UniqueId = uniqueId;
    }

    public Integer getCurrentProcessID() {
        return CurrentProcessID;
    }

    public void setCurrentProcessID(Integer currentProcessID) {
        CurrentProcessID = currentProcessID;
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

    public String getDependProcessName() {
        return DependProcessName;
    }

    public void setDependProcessName(String dependProcessName) {
        DependProcessName = dependProcessName;
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
        RecoverThread that = (RecoverThread) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(UniqueId, that.UniqueId) &&
                Objects.equals(CurrentProcessID, that.CurrentProcessID) &&
                Objects.equals(CurrentProcessName, that.CurrentProcessName) &&
                Objects.equals(PendingProcessID, that.PendingProcessID) &&
                Objects.equals(DependProcessID, that.DependProcessID) &&
                Objects.equals(DependProcessName, that.DependProcessName) &&
                Objects.equals(Time, that.Time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, UniqueId, CurrentProcessID, CurrentProcessName, PendingProcessID, DependProcessID, DependProcessName, Time);
    }

    @Override
    public String toString() {
        return "RecoverThread{" +
                "Id=" + Id +
                ", UniqueId=" + UniqueId +
                ", CurrentProcessID=" + CurrentProcessID +
                ", CurrentProcessName='" + CurrentProcessName + '\'' +
                ", PendingProcessID='" + PendingProcessID + '\'' +
                ", DependProcessID='" + DependProcessID + '\'' +
                ", DependProcessName='" + DependProcessName + '\'' +
                ", Time=" + Time +
                '}';
    }
}
