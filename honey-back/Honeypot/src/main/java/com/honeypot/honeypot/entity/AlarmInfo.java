package com.honeypot.honeypot.entity;
import java.util.Date;

public class AlarmInfo {
    private int id;
    private long uniqueId;
    private int type;
    private String processName;
    private String path;
    private String explain1;
    private String explain2;
    private Date time;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExplain1() {
        return explain1;
    }

    public void setExplain1(String explain1) {
        this.explain1 = explain1;
    }

    public String getExplain2() {
        return explain2;
    }

    public void setExplain2(String explain2) {
        this.explain2 = explain2;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;

    }
}
