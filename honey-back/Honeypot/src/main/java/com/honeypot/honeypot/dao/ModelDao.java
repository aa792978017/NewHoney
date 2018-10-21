package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelDao {
    int addModel(@Param("model") Model model);

    List<Model> getModelList();

    int delectModel(@Param("id") Integer id);
}
