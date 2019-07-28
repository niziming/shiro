package cn.ziming.shiro.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    /**
     * 用户ID
     */
    @Id
    @Column
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户角色
     *
     * @return role - 用户角色
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置用户角色
     *
     * @param role 用户角色
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}