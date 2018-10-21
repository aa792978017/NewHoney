package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.NetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NetInfoDao {
    List<NetInfo> getAllNetInfo(@Param("uniqueId") Integer uniqueId);
}
