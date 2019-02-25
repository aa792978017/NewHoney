package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.NetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NetInfoDao {

    /**
     * 根据uniqueid,获取全部网络使用情况
     * @param uniqueId
     * @return
     * */
    List<NetInfo> getAllNetInfo(@Param("uniqueId") long uniqueId);
}
