package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.WarnMsg;
import com.honeypot.honeypot.entity.WarningSum;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WarnMsgDao {

    List<AlarmInfo> getNewWarnMsg();

    /**
     * 获取最新一年里面的警告信息
     * @return
     */
    @Select("Select * from alarminfo where YEAR(time)=YEAR(NOW());")
    List<AlarmInfo> getWarnMsgNum();

    /**
     * 实时警告版获取更多信息，
     * 这里获取一年里的，因为数据库里面的数据没有最新一个月的
     * @return
     */
    @Select("Select * from alarminfo where YEAR(time)=YEAR(NOW());")
    List<AlarmInfo> getMoreWarnMsg();
}
