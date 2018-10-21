package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.WarningCriterial;
import com.honeypot.honeypot.entity.WarningSum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface WarningDao {

    List<WarningSum> getWarningSum(@Param("time") String time,@Param("flag") Integer flag);

    Integer getNumForOneDay(@Param("warn_time") String time, @Param("flag") Integer flag);

    List<WarningCriterial> getLastWarning();

    @Select(" SELECT *\n" +
            "        FROM warning_sum\n" +
            "        WHERE flag = #{flag}\n" +
            "        ORDER BY id DESC")
    List<WarningSum> getWarningByType(@Param("flag") int flag);
}
