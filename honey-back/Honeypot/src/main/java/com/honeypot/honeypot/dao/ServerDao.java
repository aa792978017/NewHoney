package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Server;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServerDao {
    /**
     * 获取所有服务器
     * @return
     */
    List<Server> getAllServer();

    /**
     * 根据服务器id获取服务器信息
     * @param serverId
     * @return
     */
    List<Server> getServerByServerId(@Param("serverId") Integer serverId);

    /**
     * 根据服务器名字获取服务器信息
     * @param serverName
     * @return
     */
    List<Server> getServerByServerName(@Param("serverName") String serverName);

    /**
     * 根据服务器id删除服务器
     * @param serverId
     * @return
     */
    int delServerByServerId(@Param("serverId") Integer serverId);

    /**
     * 根据服务器名称删除服务器
     * @param serverName
     * @return
     */
    int delServerByServerName(@Param("serverName") String  serverName);

    /**
     *
     * 添加服务器
     * @param server
     * @return
     */
    int addServer(@Param("server") Server server);

}
