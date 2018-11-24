package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.ModelDao;
import com.honeypot.honeypot.entity.Model;

import com.honeypot.honeypot.entity.ModelSet;
import com.honeypot.honeypot.service.ModelService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelDao modelDao;
    @Override
    public ArrayList<ModelSet> getModelList() {
        List<Model> models = modelDao.getModelList();
        ArrayList<ModelSet> modelSets = new ArrayList<>();
        Map<String, ArrayList<Model>> middleMap = new HashMap<>();
        for (Model model : models) {
            boolean is = middleMap.containsKey(model.getName());
            if ( !is) {
                middleMap.put(model.getName(), new ArrayList<Model>());
            }
            middleMap.get(model.getName()).add(model);
        }
        for (Map.Entry<String, ArrayList<Model>> entry : middleMap.entrySet()) {
            ModelSet modelSet = new ModelSet();
            modelSet.setModelName(entry.getKey());
            modelSet.setModels(entry.getValue());
            modelSets.add(modelSet);
        }

        return modelSets;
    }

    @Override
    @Transactional
    public int addModel(ArrayList<Model> models) {

        for (int i = 0; i < models.size(); i++ ) {
           int success =  modelDao.addModel(models.get(i));
            if (success != 1) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    @Transactional
    public int delectModel(Integer id) {
        return modelDao.delectModel(id);
    }

    @Override
    public ArrayList<Model> getModelListByName(String modelName) {
        return (ArrayList<Model>) modelDao.getModelListByName(modelName);
    }
}
