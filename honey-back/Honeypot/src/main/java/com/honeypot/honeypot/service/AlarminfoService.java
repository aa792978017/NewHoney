package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import java.util.List;

public interface AlarminfoService {
    /**
     * 根据类型,uniqueId获取告警信息
     * @return
     */
    List<AlarmInfo> getAlarminfoByUniqueId(int type,long uniqueId);
    /**
     * 根据id获取详细告警信息
     * @return
     */
    List<AlarmextendInfo> getAlarmExtendinfoById(int id);

}
