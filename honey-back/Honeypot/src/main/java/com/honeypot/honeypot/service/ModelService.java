package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.Model;
import com.honeypot.honeypot.entity.ModelSet;

import java.util.ArrayList;
import java.util.List;

public interface ModelService {
    /**
     * 获取模板列表
     * @return
     */
    ArrayList<ModelSet> getModelList();

    /**
     * 添加模板
     * @param model
     * @return
     */
    int addModel(ArrayList<Model> model);

    /**
     * 删除模板
     * @param id
     * @return
     */
    int delectModel(Integer id);

    /**
     * 通过模板名字查找模板信息
     * @return
     */
    ArrayList<Model> getModelListByName(String modelName);




}
