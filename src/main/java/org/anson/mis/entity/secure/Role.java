package org.anson.mis.entity.secure;

import org.anson.mis.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {

    /**
     * 角色编码
     */
    @Column(name = "no")
    private String no;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色描述
     */
    @Column(name = "description")
    private String description;

    public Role() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
