package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.WarningDao;
import com.honeypot.honeypot.entity.WarningSum;
import com.honeypot.honeypot.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WarningServiceImp implements WarningService {
    @Autowired
    private WarningDao warningDao;

    @Override
    public Map<String, Object> getSumOfWarningSumForMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        Date today = new Date();
        String day = df.format(today);
        int year = Integer.parseInt(day.substring(0, day.indexOf("-")));
        int month = Integer.parseInt(day.substring(day.indexOf("-") + 1));
        System.out.println("year:" + year);
        List<WarningSum> sumsOfSensitive = warningDao.getWarningSum("%" + "" + "%", 1);
        List<WarningSum> sumsOfBA = warningDao.getWarningSum("%" + "" + "%", 0);
        List<WarningSum> sumsOfVirtual = warningDao.getWarningSum("%" + "" + "%", 2);
        Map<String, Object> sensitiveItem = new LinkedHashMap<String, Object>();
        Map<String, Object> BAItem = new LinkedHashMap<String, Object>();
        Map<String, Object> virtualItem = new LinkedHashMap<String, Object>();

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        BAItem.put("className", ".pizza");

        for (int i = 1; i <= 12; i++) {
            Map<String, Object> tmp = new HashMap<String, Object>();
            String monthStr = "";
            if (month < 10) {
                monthStr = year + "-" + "0" + month;
            } else {
                monthStr = year + "-" + month;
            }

            Integer sum = 0;
            for (WarningSum ws : sumsOfBA) {
                if (ws.getTime().equalsIgnoreCase(monthStr)) {
                    sum = ws.getNum();
                    break;
                }
            }
            tmp.put("x", monthStr);
            tmp.put("y", sum);
            data.add(tmp);
            month -= 1;
            if (month == 0) {
                month = 12;
                year -= 1;
            }
        }
        Collections.reverse(data);
        BAItem.put("data", data);


        year = Integer.parseInt(day.substring(0, day.indexOf("-")));
        month = Integer.parseInt(day.substring(day.indexOf("-") + 1));
        sensitiveItem.put("className", ".main.l2");
        data = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 12; i++) {
            Map<String, Object> tmp = new HashMap<String, Object>();
            String monthStr = "";
            if (month < 10) {
                monthStr = year + "-" + "0" + month;
            } else {
                monthStr = year + "-" + month;
            }

            Integer sum = 0;
            for (WarningSum ws : sumsOfSensitive) {
                if (ws.getTime().equalsIgnoreCase(monthStr)) {
                    sum = ws.getNum();
                    break;
                }
            }
            tmp.put("x", monthStr);
            tmp.put("y", sum);
            data.add(tmp);
            month -= 1;
            if (month == 0) {
                month = 12;
                year -= 1;
            }
        }
        Collections.reverse(data);
        sensitiveItem.put("data", data);

        year = Integer.parseInt(day.substring(0, day.indexOf("-")));
        month = Integer.parseInt(day.substring(day.indexOf("-") + 1));
        virtualItem.put("className", ".main.l3");
        data = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 12; i++) {
            Map<String, Object> tmp = new HashMap<String, Object>();
            String monthStr = "";
            if (month < 10) {
                monthStr = year + "-" + "0" + month;
            } else {
                monthStr = year + "-" + month;
            }

            Integer sum = 0;
            for (WarningSum ws : sumsOfVirtual) {
                if (ws.getTime().equalsIgnoreCase(monthStr)) {
                    sum = ws.getNum();
                    break;
                }
            }
            tmp.put("x", monthStr);
            tmp.put("y", sum);
            data.add(tmp);
            month -= 1;
            if (month == 0) {
                month = 12;
                year -= 1;
            }
        }
        Collections.reverse(data);
        virtualItem.put("data", data);


        Map<String, Object> res = new LinkedHashMap<String, Object>();
        res.put("xScale", "time");
        res.put("yScale", "linear");
        List<Map<String, Object>> main = new ArrayList<Map<String, Object>>();
//		main.add(BAItem);
        main.add(BAItem);
        main.add(sensitiveItem);
        main.add(virtualItem);
        res.put("main", main);

        return res;
    }

    @Override
    public Integer getSumOfWarningSumForYear(Integer flag) {
        List<WarningSum> sums = warningDao.getWarningSum("%"+""+"%", flag);
        Integer sum = 0;
        for(WarningSum ws : sums){
            sum += ws.getNum();
        }
        return sum;
    }

    @Override
    public List<List<Object>> getNumOfWarningFor7DaysNew(Integer flag) {
        List<List<Object>> numList = new ArrayList<List<Object>>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        for(int i = 0; i < 7; i++){
            List<Object> map = new ArrayList<Object>();
            String day = df.format(today);
            Integer num = warningDao.getNumForOneDay("%"+day+"%", flag);
            day = day.substring(day.indexOf("-")+1);
            day = day.substring(day.indexOf("-")+1);
            map.add(Integer.parseInt(day));
            System.out.println("ddddd: " + num);
            map.add(num);
            calendar.setTime(today);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            today = calendar.getTime();
            numList.add(map);
        }
        System.out.println(numList);
        Collections.reverse(numList);
        return numList;
    }

    @Override
    public List<WarningSum> getAllWarningSum(Integer flag) {
        List<WarningSum> warningSumList = new ArrayList<>();
        warningSumList = warningDao.getWarningByType(flag);
        while(warningSumList.size() > 8){
            warningSumList.remove(warningSumList.size() - 1);
        }
        System.out.println(warningSumList.size());
        return warningSumList;
    }
}
