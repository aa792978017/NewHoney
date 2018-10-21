package com.honeypot.honeypot.dao;


import com.honeypot.honeypot.entity.SystemSecurityConf;

import java.util.List;

public interface SystemSecurityConfDao {
    // 获取系统安全配置
    public List<SystemSecurityConf> getSystemSecurityConf();
    // 根据confName获取单个系统安全配置
    public SystemSecurityConf getAConfByName(String confName);
    // 更新系统安全配置
    public boolean updateSystemSecurityConf(SystemSecurityConf updateConf);
}
