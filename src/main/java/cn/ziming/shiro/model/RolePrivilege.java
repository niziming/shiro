package cn.ziming.shiro.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class RolePrivilege {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "PRIVILEGE_ID")
    private Integer privilegeId;

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

    /**
     * @return PRIVILEGE_ID
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * @param privilegeId
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}