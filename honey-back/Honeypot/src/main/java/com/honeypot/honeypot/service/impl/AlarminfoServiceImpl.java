package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.AlarminfoDao;
import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import com.honeypot.honeypot.service.AlarminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlarminfoServiceImpl implements AlarminfoService {
    @Autowired
    private AlarminfoDao alarmInfoDao;

    @Override
    public List<AlarmInfo> getAlarminfoByUniqueId(int type,long uniqueId) {
//        List<AlarmInfo> AlarmInfoList = new ArrayList<AlarmInfo>();
//        AlarmInfoList = alarmInfoDao.getAlarminfoByUniqueId(type,uniqueId);
//        for(int i = 0; i < AlarmInfoList.size();i++){
//            AlarmInfoList.get(i);
//        }

        return alarmInfoDao.getAlarminfoByUniqueId(type,uniqueId);
    }

    @Override
    public List<AlarmextendInfo> getAlarmExtendinfoById(int id) {
        return alarmInfoDao.getAlarmExtendinfoById(id);
    }
}
