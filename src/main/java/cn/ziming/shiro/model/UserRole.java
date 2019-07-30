package cn.ziming.shiro.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserRole {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return ROLE_ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}