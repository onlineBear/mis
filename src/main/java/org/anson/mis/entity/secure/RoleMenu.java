package org.anson.mis.entity.secure;

import org.anson.mis.entity.base.BaseEntity;
import org.anson.mis.entity.system.Menu;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_menu")
public class RoleMenu extends BaseEntity {

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public RoleMenu() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
