package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.WarnMsgDao;
import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmInfoResult;
import com.honeypot.honeypot.service.WarnMsgService;
import com.honeypot.honeypot.util.AlarmInfoUtil;
import com.honeypot.honeypot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarnMsgServiceImpl implements WarnMsgService {
    @Autowired
    private WarnMsgDao warnMsgDao;

    @Override
    public Map<String,Object> getWarnMsgNum() {
        Map<String,Object> modelMap = new HashMap<>();
        List<AlarmInfo> alarmInfos = new ArrayList<>();
        alarmInfos = warnMsgDao.getWarnMsgNum();
        DateFormat dateFormat = DateFormat.getDateInstance();
        String now = dateFormat.format(new Date());
        int warnDayOne = 0;
        int warnDayTwo = 0;
        int warnDayThree = 0;
        int warnDayFour = 0;
        int warnDayFive = 0;
        int warnDaySix = 0;
        int warnDaySeven = 0;
        List<String> timeList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        String one =  DateUtil.getSpecifiedDayBefore(now,7);
        String two =  DateUtil.getSpecifiedDayBefore(now,6);
        String three =  DateUtil.getSpecifiedDayBefore(now,5);
        String four =  DateUtil.getSpecifiedDayBefore(now,4);
        String five =  DateUtil.getSpecifiedDayBefore(now,3);
        String six =  DateUtil.getSpecifiedDayBefore(now,2);
        String seven =  DateUtil.getSpecifiedDayBefore(now,1);
        timeList.add(one.substring(5,10));
        timeList.add(two.substring(5,10));
        timeList.add(three.substring(5,10));
        timeList.add(four.substring(5,10));
        timeList.add(five.substring(5,10));
        timeList.add(six.substring(5,10));
        timeList.add(seven.substring(5,10));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(AlarmInfo alarmInfo : alarmInfos){
            String alarmInfoTime = DateUtil.getSpecifiedDayBefore(simpleDateFormat.format(alarmInfo.getTime()),0);
            if (alarmInfoTime.equals(one))
                warnDayOne++;
            else if (alarmInfoTime.equals(two))
                warnDayTwo++;
            else if (alarmInfoTime.equals(three))
                warnDayThree++;
            else if (alarmInfoTime.equals(four))
                warnDayFour++;
            else if (alarmInfoTime.equals(five))
                warnDayFive++;
            else if (alarmInfoTime.equals(six))
                warnDaySix++;
            else if (alarmInfoTime.equals(seven))
                warnDaySeven++;
        }

        sumList.add(warnDayOne);
        sumList.add(warnDayTwo);
        sumList.add(warnDayThree);
        sumList.add(warnDayFour);
        sumList.add(warnDayFive);
        sumList.add(warnDaySix);
        sumList.add(warnDaySeven);
        modelMap.put("timeList",timeList);
        modelMap.put("sumList",sumList);
        return modelMap;
    }

    @Override
    public List<AlarmInfoResult> getNewWarnMsg() {
        List<AlarmInfo> alarmInfoList = warnMsgDao.getNewWarnMsg();
        List<AlarmInfoResult> alarmInfoResults = new ArrayList<>();
        DateFormat dateFormat = DateFormat.getDateInstance();
        for (AlarmInfo alarmInfo : alarmInfoList){
            AlarmInfoResult alarmInfoResult = new AlarmInfoResult();
            alarmInfoResult.setWarnType("虚拟机警告");
            alarmInfoResult.setWarn(AlarmInfoUtil.typeMap(alarmInfo));
            alarmInfoResult.setTime(dateFormat.format(alarmInfo.getTime()));
            alarmInfoResults.add(alarmInfoResult);
        }
        return alarmInfoResults;
    }

    @Override
    public List<AlarmInfoResult> getMoreWarnMsg() {
        List<AlarmInfo> alarmInfoList = warnMsgDao.getMoreWarnMsg();
        List<AlarmInfoResult> alarmInfoResultList = new ArrayList<>();
        DateFormat dateFormat = DateFormat.getDateInstance();
        int i = 1;
        for (AlarmInfo alarmInfo : alarmInfoList){
            AlarmInfoResult alarmInfoResult = new AlarmInfoResult();
            alarmInfoResult.setIndex(i++);
            alarmInfoResult.setWarnType("虚拟机警告");
            alarmInfoResult.setWarn(AlarmInfoUtil.typeMap(alarmInfo));
            alarmInfoResult.setTime(dateFormat.format(alarmInfo.getTime()));
            alarmInfoResultList.add(alarmInfoResult);
        }
        return alarmInfoResultList;
    }
}
