package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.SampleDao;
import com.honeypot.honeypot.entity.Sample;
import com.honeypot.honeypot.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleDao sampleDao;
    @Override
    public List<Sample> getAllSample() {
        List<Sample> sampleList = sampleDao.getAllSample();
        for (Sample sample : sampleList) {
            if (sample.getFilePath() == null) {
                sample.setFilePath("www.baidu.com");
            }
        }
        return sampleList;
    }

    @Override
    public List<Sample> getSampleByWords(String words) {
        List<Sample> sampleList =  sampleDao.getSample(words);
        for (Sample sample : sampleList) {
            if (sample.getFilePath() == null) {
                sample.setFilePath("www.baidu.com");
            }
        }
        return sampleList;
    }
}
