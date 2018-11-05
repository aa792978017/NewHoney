package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Host;
import com.honeypot.honeypot.entity.HostType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import java.util.List;

@Mapper
public interface HostDao {
    /**
     * 与原来的BaseDao方法有出入，注意
     * @param state
     * @return
     */
     List<Host> getAllRowCountByState(@Param("state") Object state);

     List<HostType> getAllRowCountByHostType(@Param("hostType") Object hostType);

    /**
     * 获取所有host类型
     * @return
     */
    List<HostType> getAllTypes();

    /**
     * 根据省份获取host
     * @return
     */
    List<Host> getHostByProvince(@Param("province")Integer province);
}
