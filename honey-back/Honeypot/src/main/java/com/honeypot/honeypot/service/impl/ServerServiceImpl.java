package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.ServerDao;
import com.honeypot.honeypot.entity.Server;
import com.honeypot.honeypot.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerDao serverDao;

    @Override
    public List<Server> getAllServer() {
        return serverDao.getAllServer();
    }

    @Override
    public List<Server> getServerByServerId(Integer serverId) {
        return serverDao.getServerByServerId(serverId);
    }

    @Override
    public List<Server> getServerByServerName(String serverName) {
        return serverDao.getServerByServerName(serverName);
    }

    @Override
    public int delServerByServerId(Integer serverId) {
        return serverDao.delServerByServerId(serverId);
    }

    @Override
    public int delServerByServerName(String serverName) {
        return serverDao.delServerByServerName(serverName);
    }

    @Override
    public int addServer(Server server) {
        return serverDao.addServer(server);
    }
}
