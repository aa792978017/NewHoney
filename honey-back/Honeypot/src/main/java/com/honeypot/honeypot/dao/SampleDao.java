package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Sample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SampleDao {

    List<Sample> getAllSample();

    List<Sample> getSample(@Param("words") String words);
}
