package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.Model;

import java.util.List;

public interface ModelService {
    /**
     * 获取模板列表
     * @return
     */
    List<Model> getModelList();

    /**
     * 添加模板
     * @param model
     * @return
     */
    int addModel(Model model);

    /**
     * 删除模板
     * @param id
     * @return
     */
    int delectModel(Integer id);



}
