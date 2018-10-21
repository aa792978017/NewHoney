package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.Sample;

import java.util.List;

public interface SampleService {
    /**
     * 获取所有样本信息
     * @return
     */
    List<Sample> getAllSample();

    /**
     * 模糊查询样本信息
     * @return
     */
    List<Sample> getSampleByWords(String words);
}
