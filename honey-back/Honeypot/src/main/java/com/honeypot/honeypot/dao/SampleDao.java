package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Sample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SampleDao {
    /**
     * 获取所有样本信息
     * @return
     */
    List<Sample> getAllSample();

    /**
     * 模糊查询样本信息
     * @param words
     * @return
     */
    List<Sample> getSample(@Param("words") String words);
}
