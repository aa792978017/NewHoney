package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.ModelUtil;
import com.honeypot.honeypot.entity.*;
import com.honeypot.honeypot.service.*;
import com.honeypot.honeypot.util.BuildXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.honeypot.honeypot.entity.ModelUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@CrossOrigin
@ResponseBody
public class HostManageController {
    @Autowired
    private HostManagementService hostManagementService;
    @Autowired
    private ServerService serverService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CityService cityService;

    @Autowired
    private PotService potService;
    @Autowired
    private ModelService modelService;
    /**
     * 获取不同状态值的数量
     *
     * @return
     */
    @GetMapping(value = "/getStateCounts")
    public Map<String, String> getStateCounts(){
        Map<String, String> state = new HashMap<String, String>();
        state.put("monitor", String.valueOf(hostManagementService.getStateCount(1)));
        state.put("pause", String.valueOf(hostManagementService.getStateCount(3)));
        state.put("unknown", String.valueOf(hostManagementService.getStateCount(-1)));
        state.put("wait", String.valueOf(hostManagementService.getStateCount(2)));
        return state;
    }

    /**
     * 没问题
     * @return
     */
    @GetMapping("/getHostTypeCounts")
    public List<Map<String, String>> getHostTypeCounts(){
        List<HostType> hostTypes = hostManagementService.getHostTypes();
        List<Map<String, String>> count = new ArrayList<Map<String,String>>();
        for(HostType h:hostTypes){
            Map<String, String> host = new HashMap<String, String>();

            host.put("label", h.getTypeName());
            host.put("data", String.valueOf(hostManagementService.getHostTypeCount(h.getId())));
            count.add(host);
        }
        return count;

    }

    /**
     *获取省市
     * @return
     */
    @GetMapping("/getDepCounts")
    public List<Map<String, String>> getDepCounts(){

        List<Province> provinces = hostManagementService.getProvinces();
        List<Map<String, String>> modelMapcount = new ArrayList<Map<String,String>>();
        for(Province department : provinces){
            Map<String, String> dep = new HashMap<String, String>();
            dep.put("label", department.getName());
            dep.put("data", String.valueOf(hostManagementService.getDepTypeCount(department.getId())));
            modelMapcount.add(dep);
        }
        return  modelMapcount;
    }

    /**
     * 获取操作系统数量信息
     * @return
     */
    @GetMapping("/getOsCounts")
    public List<Map<String, String>> getOsCounts(){
        List<OsType> osTypes = hostManagementService.getOsTypes();
        List<Map<String, String>> modelMapcount = new ArrayList<Map<String,String>>();
        for(OsType osType : osTypes){
            Map<String, String> dep = new HashMap<String, String>();
            dep.put("label", osType.getTypeName());
            dep.put("data", String.valueOf(hostManagementService.getOsCount(osType.getId())));
            modelMapcount.add(dep);
        }

        return modelMapcount;
    }

    /**
     * 功能已经被取消，暂时留住方法
     * @return
     */
    @GetMapping("/getWarnings")
    public List<WarningCriterial> getWarnings(){
        List<WarningCriterial> warnings = hostManagementService.getLastWarning();
        return  warnings;
    }

    /**
     * 查找所有服务器
     * @return
     */
    @GetMapping("/getAllServer")
    public Map<String,Object> getAllServer(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Server> serverList = serverService.getAllServer();
        modelMap.put("serverList",serverList);
        if (serverList.size() > 0){
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);

        }
        return modelMap;
    }

    /**
     * 查找服务器
     * @param server
     * @return
     */
    @GetMapping("/getServer")
    public Map<String,Object> getServer(@RequestParam(value = "server",required = false, defaultValue = "") Server server, HttpSession session){
        System.out.println("用户名是：：：：：" + session.getAttribute("username"));
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Server server1 = server;
        List<Server> serverList = null;
        if (server1==null){
            serverList = serverService.getAllServer();
        }else {
            if (null != new Integer(server1.getId())){
                serverList = serverService.getServerByServerId(new Integer(server1.getId()));
            }else if (null != server1.getServer() && !server1.getServer().equals("")){
                serverList = serverService.getServerByServerName(server1.getServer());
            }else {
                modelMap.put("errMsg","操作错误");
            }

        }
        modelMap.put("serverList",serverList);
        if (serverList.size() > 0){
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);

        }
        return modelMap;
    }

    /**
     * 增加服务器
     * @param server
     * @return
     */
    @PostMapping("/addServer")
    public Map<String,Object> addServer(@RequestParam(value = "server") String server,@RequestParam(value = "serverIp")String serverIp){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Server serverNew = new Server();
        serverNew.setServerIp(serverIp);
        serverNew.setServer(server);
        List<Server> serverList = null;
        if (serverNew != null){
            int success = serverService.addServer(serverNew);
            serverList = serverService.getAllServer();
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
        }
        modelMap.put("serverList",serverList);
        return modelMap;
    }

    /**
     * 删除服务器
     * @param
     * @return
     */
    @PostMapping("/delServer")
    public Map<String,Object> delServer(@RequestBody ArrayList<Integer> arrayList){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        int sum = 0;
        for (Integer integer : arrayList){
//            Server server1 = new Server();
//            server1.setId(arrayList.get(integer));
            serverService.delServerByServerId(integer);
            sum++;
        }
        if (sum == arrayList.size()){
            modelMap.put("success",true);
        } else {
            modelMap.put("success",false);
        }
        return modelMap;

    }

    /**
     * 应用蜜罐-应用蜜罐信息页面，，用于获取应用蜜罐信息
     * @return
     */
    @GetMapping("/getListHost")
    @ResponseBody
    public List<Pot> listHost() {
//
//        if(hostType != null && hostType == 0){
//            hostType = null;
//        }
//        if(osType != null && osType == 0){
//            osType = null;
//        }
//        if(state != null && state == 0){
//            state = null;
//        }
//        if(city != null && city == 0){
//            city = null;
//        }
//        if(province != null && province == 0){
//            province = null;
//        }
//        if(city != null && city == 0){
//            city = null;
//        }
//
//        if(macAddress != null && isIllegal(macAddress)){
//            return "wformat";
//        }
//        if(ip != null && isIllegal(ip)){
//            return "wformat";
//        }
//        if(username != null && isIllegal(username)){
//            return "wformat";
//        }
//        if(cpu != null && isIllegal(cpu)){
//            return "wformat";
//        }
//        if(memory != null && isIllegal(memory)){
//            return "wformat";
//        }
//        if(hostname != null && isIllegal(hostname)){
//            return "wformat";
//        }

//        Object[] values = new Object[]{macAddress, ip, hostname, username, hostType, osType, cpu, memory, state, company, city, province};
////        System.out.println("p:"+province);
////        String hql = null;
////        PageBean pageBean = houHostManagementService.queryForPage(pageSize, currentPage, hql, values);
        List<OsType> osTypes = hostManagementService.getOsTypes();
        List<HostType> hostTypes = hostManagementService.getHostTypes();
        List<Department> departments = departmentService.getAllDepartment();
        List<StateType> stateTypes = hostManagementService.getAllStateType();
        List<Province> provinces = hostManagementService.getProvinces();
        List<Pot> potList = potService.getPotByType("");   //暂时把type写死
//        requestAwareMap.put("page", pageBean);
        Map<String, Object> modelMap = new HashMap<String, Object>();
//        modelMap.put("osTypes", osTypes);
//        modelMap.put("hostTypes", hostTypes);
//        modelMap.put("departments", departments);
//        modelMap.put("stateTypes", stateTypes);
//        modelMap.put("provinces", provinces);
        modelMap.put("potList",potList);
        return potService.getPotByType("");
//        for (Province p1 : provinces) {
//            modelMap.put("osTypes", osTypes);
//            modelMap.put("hostTypes", hostTypes);
//            modelMap.put("departments", departments);
//            modelMap.put("stateTypes", stateTypes);
//            modelMap.put("provinces", provinces);
//            return modelMap;
//            modelMap.put("macAddress1", macAddress);
//            modelMap.put("ip1", ip);
//            modelMap.put("hostname1", hostname);
//            modelMap.put("username1", username);
//            modelMap.put("hostType1", hostType);
//            modelMap.put("osType1", osType);
//            modelMap.put("cpu1", cpu);
//            modelMap.put("memory1", memory);
//            modelMap.put("state1", state);
//            modelMap.put("departmentId1", departmentId);
//            System.out.println("ListHost done...");
//            System.out.println(p1.getName());
//        }
//        return "success";
//        }
    }

    /**
     * 通过ip获取Pot信息
     * @param ip
     * @return
     */
    @GetMapping("/getPotByIp")
    public List<Pot> getPotByIp(@RequestParam(value = "ip")String ip){
        return potService.getPotByIp(ip+"%");
    }

    /**
     * 获取模板列表
     * @return
     */
    @PostMapping("/getModelList")
    public ArrayList<ModelSet> getModelList(){
        ArrayList<ModelSet> modelList = new ArrayList<>();
        modelList = modelService.getModelList();
        int i = 1;
        for(ModelSet modelSet : modelList){
            modelSet.setIndex(i);
            i++;
        }
        return modelList;
    }

    /**
     * 增加模板方法
     * @return
     */
    @PostMapping("/addModel")
    public Map<String,Object> addModel(@RequestBody JSONArray jsonArray){
        Map<String,Object> modelMap = new HashMap<>();
        JSONObject modelData;
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            Model model = new Model();
            modelData = jsonArray.getJSONObject(i);
            model.setIp(modelData.getString("ip"));
            model.setType(modelData.getString("type"));
            model.setServerIp(modelData.getString("serverIp"));
            model.setServer(modelData.getString("server"));
            model.setServerId(modelData.getString("serverId"));
            model.setName(modelData.getString("name"));
            models.add(model);
        }
        if (models.size() != 0 && modelService.addModel(models) == 1){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }
    /**
     * 删除模板
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delectModel", method = RequestMethod.POST)
    public JSONObject addUser(@RequestBody ArrayList<Integer> arrayList){
        JSONObject modelMap = new JSONObject();
        int sum = 0;
        for (Integer integer: arrayList) {
            modelService.delectModel(integer);
            sum++;
        }
        if (sum == arrayList.size()) {
            modelMap.put("success",true);
        } else {
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 部署网络功能，需要调用client.py脚本
     * @return
     */
    @PostMapping("/setNetWork")
    public String addPot(@RequestBody String modelName){
        List<Model> models =  modelService.getModelListByName(modelName);
        BuildXmlUtil buildXmlUtil = new BuildXmlUtil();
//		String pyPath = "C:\\Users\\DELL\\Desktop\\client.py";
//		String xmlPath = "C:\\Users\\DELL\\Desktop\\xxx.xml";
        String pyPath = "D:\\github repository\\NewHoney\\honey-back\\Honeypot\\src\\main\\java\\com\\honeypot\\honeypot\\util\\client.py";
        String xmlPath = "D:\\github repository\\NewHoney\\honey-back\\Honeypot\\src\\main\\java\\com\\honeypot\\honeypot\\util\\xxx.xml";
        for (Model m : models){
            buildXmlUtil.buildNode(m);
        }
        buildXmlUtil.buildXml(xmlPath);
        String[] command = new String[]{"python", pyPath, xmlPath};
        List<String> pythonResult = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null && !"done".equals(line)) {
                pythonResult.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] array = new String[7];
        for (String result : pythonResult){
            System.out.println("result="+result);
            array = result.split(":");
            Pot pot = new Pot();
            pot.setCpu("1cpu");
            pot.setMemory("5g");
            pot.setDisk("100g");
            pot.setIp(array[3]);
            pot.setUniqueId(array[0]);
            pot.setDomainId(array[1]);
            pot.setServer(array[5]);
            pot.setServerId(Integer.valueOf(array[4]));
            pot.setServerIp(array[6]);
            pot.setState(1);
            if(array[2].equals("t-pot")){
                pot.setType("复合蜜罐");
            }
            else{
                pot.setType(array[2]);
            }
            potService.addPot(pot);
        }
        return "success";
    }

}
