package com.honeypot.honeypot.entity;

/**
 * Created by xiejing on 18/4/11.
 */
public class Server {
    private Integer id;
    private String server;
    private String serverIp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server1 = (Server) o;

        if (id != server1.id) return false;
        if (server != null ? !server.equals(server1.server) : server1.server != null) return false;
        if (serverIp != null ? !serverIp.equals(server1.serverIp) : server1.serverIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (serverIp != null ? serverIp.hashCode() : 0);
        return result;
    }
}
