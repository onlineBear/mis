package org.anson.mis.entity.secure;

import org.anson.mis.entity.base.BaseEntity;
import org.anson.mis.entity.system.User;

import javax.persistence.*;

@Entity
@Table(name = "sys_user_role")
public class UserRole extends BaseEntity {
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
