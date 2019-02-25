package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarminfoDao {
    /**
     * 通过类型获取告警分析
     * @param type
     * @param uniqueId
     * @return0
     */
    List<AlarmInfo> getAlarminfoByUniqueId(@Param("type") int type,@Param("uniqueId") long uniqueId);
    /**
     * 通过id获取详细告警分析
     * @param id
     * @return
     */
    List<AlarmextendInfo> getAlarmExtendinfoById(@Param("id") int id);
}