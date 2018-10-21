package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.WarnMsg;
import com.honeypot.honeypot.entity.WarningSum;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WarnMsgDao {

    List<AlarmInfo> getNewWarnMsg();

    @Select("Select * from alarminfo where YEAR(time)=YEAR(NOW());")
    List<AlarmInfo> getWarnMsgNum();

    @Select("Select * from alarminfo where YEAR(time)=YEAR(NOW());")
    List<AlarmInfo> getMoreWarnMsg();
}
