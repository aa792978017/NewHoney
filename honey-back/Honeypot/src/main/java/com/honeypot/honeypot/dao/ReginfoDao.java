package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Reginfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReginfoDao {

    /**
     * 根据uniqueid,获取全部注册表基本信息
     * @param uniqueId
     * @return
     * */
    List<Reginfo> getAllReginfo(@Param("uniqueId")Integer uniqueId);
}
