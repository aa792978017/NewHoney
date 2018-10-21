package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.ModelDao;
import com.honeypot.honeypot.entity.Model;
import com.honeypot.honeypot.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelDao modelDao;
    @Override
    public List<Model> getModelList() {
        return modelDao.getModelList();
    }

    @Override
    public int addModel(Model model) {
        return modelDao.addModel(model);
    }

    @Override
    public int delectModel(Integer id) {
        return modelDao.delectModel(id);
    }
}
