package com.honeypot.honeypot.entity;

import java.util.Date;

public class AlarmextendInfo {
    private int id;
    private int uniqueId;
    private int tempId;
    private int opType;
    private String processName1;
    private String Path;
    private String processName2;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
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
