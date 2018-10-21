package com.honeypot.honeypot.controller;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmInfoResult;
import com.honeypot.honeypot.entity.WarningSum;
import com.honeypot.honeypot.service.WarnMsgService;
import com.honeypot.honeypot.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class WarnMsgController {
    @Autowired
    private WarningService warningService;

    @Autowired
    private WarnMsgService warnMsgService;

    /**
     * 没问题
     * @return
     */
    @RequestMapping(value = "/getSumOfWarningSumForMonth",method = RequestMethod.GET)
    public Map<String,Object> getSumOfWarningSumForMonth(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap = warningService.getSumOfWarningSumForMonth();
        return modelMap;
    }
    //以下是还没有测试的


//    @GetMapping(value = "")
//    public void getOrignialLogsForMac(){
//        Map<String, String> items = getItems();
//        String json = logQueryService.getOriginalLogsForMac(macAddress, "original", items, page, pageSize);
//
//    }

    /**
     * 没问题
     * @return
     */
    @GetMapping(value = "/getWarningSum")
    public List<Integer> getWarningSum(HttpSession session){
        Map<String, Integer> sums = new HashMap<String, Integer>();
        Integer sumOfSensitive = warningService.getSumOfWarningSumForYear(1);
        Integer sumOfSeq = warningService.getSumOfWarningSumForYear(0);
        Integer sumOfVir = warningService.getSumOfWarningSumForYear(2);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("用户名是：：：：：" + session.getAttribute("username"));
        list.add(sumOfSeq);
        list.add(sumOfSensitive);
        list.add(sumOfVir);
        sums.put("sensitive", sumOfSensitive);
        sums.put("BA", sumOfSeq);
        sums.put("virtual", sumOfVir);
       return list;
    }

    /**
     * 获取警告数字，正确待定
     */
    @GetMapping(value = "/getWarningNum")
    public List<Object> getWarningNum(){
        //new
        List<List<Object>> warningListForB = warningService.getNumOfWarningFor7DaysNew(0);
        List<List<Object>> warningListForS = warningService.getNumOfWarningFor7DaysNew(1);
        List<List<Object>> warningListForV = warningService.getNumOfWarningFor7DaysNew(2);
        List<Object> res = new ArrayList<Object>();
        res.add(warningListForB);
        res.add(warningListForS);
        res.add(warningListForV);
        return res;
    }

    @GetMapping("/getAllWarningSum")
    public Map<String,Object> getAllWarningSum(){
        Map<String,Object> modelMap = new HashMap<>();
        List<String> timeList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        List<WarningSum> warningSumList = new ArrayList<>();
        warningSumList = warningService.getAllWarningSum(2);
        for (WarningSum warningSum :warningSumList){
            timeList.add(warningSum.getTime());
            numList.add(warningSum.getNum());
        }
        modelMap.put("timeList",timeList);
        modelMap.put("numList",numList);

        return modelMap;
    }
    @GetMapping("/getWarnMsgNum")
    public Map<String,Object> getWarnMsgNum(){
        Map<String,Object> modelMap = new HashMap<>();
//        modelMap = warnMsgService.getWarnMsgNum();
        return warnMsgService.getWarnMsgNum();
    }

    @GetMapping("/getNewWarnMsg")
    public List<AlarmInfoResult> getNewWarnMsg(){
        return warnMsgService.getNewWarnMsg();
    }
    @GetMapping("/getMoreWarnMsg")
    public List<AlarmInfoResult> getMoreWarnMsg(){
        return warnMsgService.getMoreWarnMsg();
    }



}
