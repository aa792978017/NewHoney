package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Pot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PotDao {
    List<Pot> getPotByType(@Param("type") String type);
    List<Pot> getHostPotByType(@Param("type") String type);
    List<Pot> getPotByIp(@Param("ip") String ip);
    // 删除一个用户
    public boolean delPot(String ip);
}
