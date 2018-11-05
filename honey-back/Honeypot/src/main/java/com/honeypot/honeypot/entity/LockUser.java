package com.honeypot.honeypot.entity;

import java.util.Date;

public class LockUser {
    private int id;
    private int userId;
    private String pwdStartTime;
    private Date pwdLoginTime;
    private Date pwdLoginDate;
    private int tryTimes;
    // 1表示锁了，0表示未锁
    private int locked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPwdStartTime() {
        return pwdStartTime;
    }

    public void setPwdStartTime(String pwdStartTime) {
        this.pwdStartTime = pwdStartTime;
    }

    public Date getPwdLoginTime() {
        return pwdLoginTime;
    }

    public void setPwdLoginTime(Date pwdLoginTime) {
        this.pwdLoginTime = pwdLoginTime;
    }

    public Date getPwdLoginDate() {
        return pwdLoginDate;
    }

    public void setPwdLoginDate(Date pwdLoginDate) {
        this.pwdLoginDate = pwdLoginDate;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
