package com.honeypot.honeypot.controller;

import com.honeypot.honeypot.entity.AlarmInfoResult;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import com.honeypot.honeypot.entity.Warning;
import com.honeypot.honeypot.entity.WarningSum;
import com.honeypot.honeypot.service.WarnMsgService;
import com.honeypot.honeypot.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：各种警告信息获取
 * 前端页面：监测状态页面
 * 开发人员：wangchang
 * @author wc
 *
 */
@RestController
@CrossOrigin
public class WarnMsgController {
    @Autowired
    private WarningService warningService;

    @Autowired
    private WarnMsgService warnMsgService;

    /**
     * 获取一个月内警告信息的总数，生成图表
     * @return
     */
    @RequestMapping(value = "/getSumOfWarningSumForMonth",method = RequestMethod.GET)
    public Map<String,Object> getSumOfWarningSumForMonth(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap = warningService.getSumOfWarningSumForMonth();
        return modelMap;
    }

    /**
     *对应实时警告分级图表
     * 返回不同类型警告的数量
     * @return
     */
    @GetMapping(value = "/getWarningSum")
    public List<Integer> getWarningSum(HttpSession session){
        Map<String, Integer> sums = new HashMap<String, Integer>();
        Integer sumOfSensitive = warningService.getSumOfWarningSumForYear(1);
        Integer sumOfSeq = warningService.getSumOfWarningSumForYear(0);
        Integer sumOfVir = warningService.getSumOfWarningSumForYear(2);
        List<Integer> list = new ArrayList<Integer>();
        list.add(sumOfSeq);
        list.add(sumOfSensitive);
        list.add(sumOfVir);
        sums.put("sensitive", sumOfSensitive);
        sums.put("BA", sumOfSeq);
        sums.put("virtual", sumOfVir);
       return list;
    }

    /**
     * 功能被取消，该方法实际运行并没有用到
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

    /**
     * 对应警告总体走势
     * @return
     */
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

    /**
     *一周总体走势图
     * 返回最近一周内，警告数量
     * @return
     */
    @GetMapping("/getWarnMsgNum")
    public Map<String,Object> getWarnMsgNum(){
        return warnMsgService.getWarnMsgNum();
    }

    /**
     * 实时警告版获取最新的警告信息
     * @return
     */
    @GetMapping("/getNewWarnMsg")
    public List<AlarmInfoResult> getNewWarnMsg(){
        return warnMsgService.getNewWarnMsg();
    }

    /**
     * 实时警告版获取更多警告信息功能
     * @return
     */
    @GetMapping("/getMoreWarnMsg")
    public List<AlarmInfoResult> getMoreWarnMsg(){
        return warnMsgService.getMoreWarnMsg();
    }

    /**
     * 实时警告版获取相信警告信息
     * @param alarmextendInfo
     * @return
     * @throws ParseException
     */
    @PostMapping("/getDetailWarn")
    public List<AlarmextendInfo>  getDetailInfo(@RequestBody AlarmextendInfo alarmextendInfo) throws ParseException {
        return warnMsgService.getDetailInfo(alarmextendInfo.getTempId());
    }

}
