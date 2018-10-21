package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.WarnMsg;
import com.honeypot.honeypot.entity.WarningSum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWarningDao  {
    @Autowired
    private WarningDao warningDao;
    @Autowired
    private WarnMsgDao warnMsgDao;

    @Test
    public void testWarningDao(){
        Map<String,Object> modelMap = new HashMap<>();
        List<AlarmInfo> alarmInfoList = warnMsgDao.getNewWarnMsg();
        System.out.println(alarmInfoList.size());


    }
}
