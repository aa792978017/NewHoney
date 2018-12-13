package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Model;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModelDao {
    /**
     * 添加模板信息
     * @param model
     * @return
     */
    int addModel(@Param("model") Model model);

    /**
     * 获取模板列表
     * @return
     */
    List<Model> getModelList();

    /**
     * 根据模板id删除模板信息
     * @param id
     * @return
     */
    int delectModel(@Param("id") Integer id);

    /**
     * 根据模板名字删除模板信息
     * @param
     * @return
     */
    int delectModelByName(@Param("name") String name);

    /**
     * 通过modelName查找模板信息
     * @param modelName
     * @return
     */
    @Select("select * from model where name = #{modelName}" )
    List<Model> getModelListByName(@Param("modelName") String modelName);
}
