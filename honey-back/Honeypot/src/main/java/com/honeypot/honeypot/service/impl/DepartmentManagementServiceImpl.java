package com.honeypot.honeypot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.DepartmentDao;
import com.honeypot.honeypot.entity.Department;
import com.honeypot.honeypot.service.DepartmentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManagementServiceImpl implements DepartmentManagementService {
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 获取全部部门信息
     * 调用departmentDao的getAllDepts方法，会得到List<Department>
     * 将每一个Department对象解析成一个JSONObject，添加进JSONArray
     * @return JSONArray 形式为
     * [{"number": xx, "department": xx, "departmentman": xx},
     *  ...,
     *  {"number": xx, "department": xx, "departmentman": xx}]
     * 其内容是根据前端而定的
     */
    @Override
    public JSONArray getAllDepts(){
        List<Department> depts = departmentDao.getAllDepts();
        JSONArray array = new JSONArray();

        for (Department dept : depts){
            JSONObject one = new JSONObject();
            one.put("id", dept.getId());
            one.put("department", dept.getDepName());
            one.put("departmentman", dept.getDutyName());
            array.add(one);
        }

        return array;
    }
    /**
     * 接下来两个getDeptByXX方法，在其他方法中会用到
     * 也可作为前端“查询”button对应的处理方法 需再确定
     */
    /**
     * 根据部门名称获得部门信息
     * @param depName
     * @return
     */
    @Override
    public Department getDeptByDepName(String depName){
        return departmentDao.getDeptByDepName(depName);
    }

    /**
     * 根据id获得部门信息
     * @param id
     * @return
     */
    @Override
    public Department getDeptById(int id){
        return departmentDao.getDeptById(id);
    }

    /**
     * 添加部门，解析前端json赋给一个Department对象，调用departmentDao的方法即可
     * @param deptJson 形式为
     *                 {
     *                  "id": x,
     *                  "depName": y,
     *                  "dutyName": z
     *                 }
     * @return result
     */
    @Override
    public JSONObject addDept(JSONObject deptJson){
        JSONObject result = new JSONObject();
        Department department = new Department();
        department.setId(deptJson.getIntValue("id"));
        department.setDepName(deptJson.getString("depName"));
        department.setDutyName(deptJson.getString("dutyName"));

        if(departmentDao.addDept(department))
            result.put("result", "添加部门成功！");
        else
            result.put("result", "添加部门失败！");

        return result;
    }

    /**
     * 删除部门，由于前端可以勾选多个，故按JSONArray处理
     * 将每一个JSONObject中的"id"取出，调用departmentDao的delDept方法删除即可
     * @param delArray
     * @return result
     * 同delUser，失败则返回发生错误的id，成功则返回success
     */
    @Override
    public JSONObject delDept(JSONArray delArray){
        JSONObject result = new JSONObject();
        for(int i = 0; i < delArray.size(); i++){
            JSONObject obj = delArray.getJSONObject(i);
            if(!departmentDao.delDept(obj.getString("depName"))){
                result.put("result", obj.getString("depName"));
                return result;
            }
        }
        result.put("result", "success");
        return result;
    }

    /**
     * 修改部门信息
     * 根据"id"获得要修改的部门对象  （考虑到option不能写死，这里的方法可能也需要修改）
     * 修改其负责人后调用departmentDao的updateDept方法即可
     * @param updateJson
     * @return
     */
    @Override
    public JSONObject updateDept(JSONObject updateJson){
        JSONObject result = new JSONObject();
        Department update = new Department();
        update = getDeptByDepName(updateJson.getString("depName"));
        update.setDutyName(updateJson.getString("dutyName"));

        if(departmentDao.updateDept(update))
            result.put("result", "更新部门成功！");
        else
            result.put("result", "更新部门失败！");

        return result;
    }
}
