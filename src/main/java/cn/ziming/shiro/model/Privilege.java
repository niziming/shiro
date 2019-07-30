package cn.ziming.shiro.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Privilege {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PRIVILEGE")
    private String privilege;

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
     * @return PRIVILEGE
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }
}