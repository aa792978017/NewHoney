package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Pot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PotDao {
    /**
     * 通过类型获取蜜罐信息
     */
    List<Pot> getPotByType(@Param("type") String type);
    /**
     * 通过蜜罐id获取蜜罐信息
     * 根据蜜罐的IP获取蜜罐信息
     */
    List<Pot> getHostPotByType(@Param("type") String type);
    /**
     * 根据蜜罐的IP获取蜜罐信息
     * @return
     */
    List<Pot> getPotByIp(@Param("ip") String ip);
    /**
     * 根据主机蜜罐的类型获取蜜罐信息
     * @param uniqueId
     * @return
     */
    public boolean delPot(String uniqueId);
}