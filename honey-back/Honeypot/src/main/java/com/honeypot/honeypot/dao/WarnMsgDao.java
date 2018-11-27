package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WarnMsgDao {
    /**
     * 通过macAddress获取alarmextendinfo信息
     * @param macAddress
     * @return
     */
    @Select("select * from alarmextendinfo where TempId = #{macAddress}")
    List<AlarmextendInfo> getAlarmextendInfoByMacAddress(String macAddress);

    /**
     * 通过macAddress获取alarmInfo信息
     * @param macAddress
     * @return
     */
    @Select("select id ,Type from alarminfo where id=#{macAddress} LIMIT 10")
    List<AlarmInfo> getAlarmInfoByMacAddress(String macAddress);


    /**
     * 从waring表获取最新的消息
     * @return
     */
    List<Warning> getNewWarnMsg();

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
    @Select("SELECT mac_address, flag, warn_time\n" +
            "        FROM warning\n" +
            "        ORDER BY warn_time DESC")
    List<Warning> getMoreWarnMsg();

    /**
     * 通过macAddress来搜索详细警告信息
     * @param tempId
     * @return
     */
    @Select("SELECT * from alarmextendinfo where TempId = #{tempId}")
    List<AlarmextendInfo> getDetailInfo(Integer tempId);
}
