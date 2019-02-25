/**
 * 仿照信工所后端的实体
 * 目的是为了将user表中，authority和dept的数值对应到角色和部门
 */
package com.honeypot.honeypot.entity;

public class UserCriteria {
    private String username;
    private String password;
    private int id;
    private String realName;
    private String authority;
    private String dept;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    // 用来转换的关键构造函数
    // 还存在问题，当部门增加时，不能依靠switch-case来选择，应当查表对应
    public UserCriteria(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.realName = user.getRealName();
        switch(user.getAuthority()){
            case 1:
                this.authority = "系统管理员"; break;
            case 2:
                this.authority = "安全审计管理员"; break;
            case 3:
                this.authority = "普通用户"; break;
            case 4:
                this.authority = "安全保密管理员"; break;
        }
        switch(user.getDept()){
            case 1:
                this.dept = "安全处"; break;
            case 2:
                this.dept = "办公室"; break;
            case 3:
                this.dept = "科技处"; break;
            case 7:
                this.dept = "测试部"; break;
            case 10:
                this.dept = "督察处"; break;
        }
    }

    public UserCriteria(){

    }
}
