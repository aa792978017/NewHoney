package com.honeypot.honeypot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SystemLog {
    private Integer id;
    private String operationUser;
    private String operationName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operationTime;
    private String remark;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOperationUser() {
        return operationUser;
    }
    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }
    public String getOperationName() {
        return operationName;
    }
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
    public Date getOperationTime() {
        return operationTime;
    }
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public SystemLog(String operationUser, String operationName,
                     Date operationTime, String remark) {
        super();
        this.operationUser = operationUser;
        this.operationName = operationName;
        this.operationTime = operationTime;
        this.remark = remark;
    }

    public SystemLog() {
        // TODO Auto-generated constructor stub
    }
}
