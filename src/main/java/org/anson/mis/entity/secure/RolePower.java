package org.anson.mis.entity.secure;

import org.anson.mis.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_power")
public class RolePower extends BaseEntity {

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "power_id")
    private Power power;

    public RolePower() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
