package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.Server;

import java.util.List;

public interface ServerService {

    /**
     * 查找所有服务器
     * @return
     */
    List<Server> getAllServer();

    /**
     * 根据服务器id查找服务器
     * @param serverId
     * @return
     */
    List<Server> getServerByServerId(Integer serverId);

    /**
     * 根据服务器名字查找服务器
     * @param serverName
     * @return
     */
    List<Server> getServerByServerName(String serverName);

    /**
     * 根据服务器id删除服务器
     * @param serverId
     * @return
     */
    int delServerByServerId(Integer serverId);

    /**
     * 根据服务器名字删除服务器
     * @param serverName
     * @return
     */
    int delServerByServerName(String serverName);

    /**
     * 添加服务器
     * @param server
     * @return
     */
    int addServer(Server server);


}
