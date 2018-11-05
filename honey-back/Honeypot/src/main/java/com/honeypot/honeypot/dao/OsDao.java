package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.OsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OsDao {
    /**
     * 获取所有os类型
     * @return
     */
    List<OsType> getAllTypes();

    /**
     * 获取ostype的数量
     * @param osType
     * @return
     */
    List<OsType> getOsTypeCountByOsType(@Param("osType") Integer osType);
}
