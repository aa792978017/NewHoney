package com.honeypot.honeypot.service.impl;


import com.honeypot.honeypot.dao.SystemSecurityConfDao;
import com.honeypot.honeypot.entity.SystemSecurityConf;
import com.honeypot.honeypot.service.SystemSecurityConfService;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemSecurityConfServiceImpl implements SystemSecurityConfService {
    @Autowired
    private SystemSecurityConfDao systemSecurityConfDao;

    /**
     * 获取系统安全配置信息
     * 调用systemSecurityConfDao的getSystemSecurityConf方法，可以得到List<SystemSecurityConf>
     * 将每一个SystemSecurityConf对象的confName和confValue对应的值添加进一个JSONObject
     * 因为表中一条记录对应一种安全配置，共四种
     * @return JSONObject
     * {
     *     "password_length": xx,
     *     "try_times": xx,
     *     "password_period": xx,
     *     "lock_period": xx
     * }
     */
    @Override
    public JSONObject getSystemSecurityConf(){
        List<SystemSecurityConf> confs = systemSecurityConfDao.getSystemSecurityConf();
        JSONObject confJson = new JSONObject();
        for(SystemSecurityConf one : confs){
            confJson.put(one.getConfName(), one.getConfValue());
        }

        return confJson;
    }

    /**
     * 获得单个系统安全配置
     * @param confName
     * @return
     */
    @Override
    public SystemSecurityConf getAConfByName(String confName){
        return systemSecurityConfDao.getAConfByName(confName);
    }

    /**
     * 修改系统安全配置
     * 根据前端传来json得到相应的配置记录
     * 比较相应值是否有变化，若有变化则更新
     * （因为表中一种配置信息一条记录，故采取这种方式）
     * @param updateConf
     * {
     *      "password_length": xx,
     *      "try_times": xx,
     *      "password_period": xx,
     *      "lock_period": xx
     * }
     * @return result
     */
    @Override
    public JSONObject updateSystemSecurityConf(JSONObject updateConf){
        JSONObject result = new JSONObject();
        SystemSecurityConf passLength = getAConfByName("password_length");
        SystemSecurityConf tryTimes = getAConfByName("try_times");
        SystemSecurityConf passPeriod = getAConfByName("password_period");
        SystemSecurityConf lockPeriod = getAConfByName("lock_period");
        if(passLength.getConfValue() != updateConf.getIntValue("password_length")){
            passLength.setConfValue(updateConf.getIntValue("password_length"));
            if(!systemSecurityConfDao.updateSystemSecurityConf(passLength)){
                result.put("result", "更新用户密码最小长度失败！");
                return result;
            }
        }
        if(tryTimes.getConfValue() != updateConf.getIntValue("try_times")){
            tryTimes.setConfValue(updateConf.getIntValue("try_times"));
            if(!systemSecurityConfDao.updateSystemSecurityConf(tryTimes)){
                result.put("result", "更新最大尝试错误次数失败！");
                return result;
            }
        }
        if(passPeriod.getConfValue() != updateConf.getIntValue("password_period")){
            passPeriod.setConfValue(updateConf.getIntValue("password_period"));
            if(!systemSecurityConfDao.updateSystemSecurityConf(passPeriod)){
                result.put("result", "更新密码失效最小周期失败！");
                return result;
            }
        }
        if(lockPeriod.getConfValue() != updateConf.getIntValue("lock_period")){
            lockPeriod.setConfValue(updateConf.getIntValue("lock_period"));
            if(!systemSecurityConfDao.updateSystemSecurityConf(lockPeriod)){
                result.put("result", "更新用户被冻结最小时间失败！");
                return result;
            }
        }

        result.put("result", "success");
        return result;
    }
}
