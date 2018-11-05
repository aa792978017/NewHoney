package com.honeypot.honeypot.entity;

public class SystemSecurityConf {
    private int id;
    private String confName;
    private int confValue;
    private String confEx1;
    private String confEx2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public int getConfValue() {
        return confValue;
    }

    public void setConfValue(int confValue) {
        this.confValue = confValue;
    }

    public String getConfEx1() {
        return confEx1;
    }

    public void setConfEx1(String confEx1) {
        this.confEx1 = confEx1;
    }

    public String getConfEx2() {
        return confEx2;
    }

    public void setConfEx2(String confEx2) {
        this.confEx2 = confEx2;
    }

    public SystemSecurityConf() {
    }
}
