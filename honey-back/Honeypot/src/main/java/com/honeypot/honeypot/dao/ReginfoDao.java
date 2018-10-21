package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Reginfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReginfoDao {
    /**
    * 获取注册表基本信息
    * */
    List<Reginfo> getAllReginfo(@Param("uniqueId")Integer uniqueId);
}
