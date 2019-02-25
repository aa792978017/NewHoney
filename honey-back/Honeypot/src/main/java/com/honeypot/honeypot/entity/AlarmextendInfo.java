package com.honeypot.honeypot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AlarmextendInfo {
    private int id;
    private long uniqueId;
    private long tempId;
    private int opType;
    private String processName1;
    private String Path;
    private String processName2;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    private String warnTime;

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public long getTempId() {
        return tempId;
    }

    public void setTempId(long tempId) {
        this.tempId = tempId;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public String getProcessName1() {
        return processName1;
    }

    public void setProcessName1(String processName1) {
        this.processName1 = processName1;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getProcessName2() {
        return processName2;
    }

    public void setProcessName2(String processName2) {
        this.processName2 = processName2;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
