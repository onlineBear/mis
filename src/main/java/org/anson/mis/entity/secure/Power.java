package org.anson.mis.entity.secure;

import org.anson.mis.entity.base.BaseEntity;
import org.anson.mis.entity.system.Menu;

import javax.persistence.*;

@Entity
@Table(name = "sys_power")
public class Power extends BaseEntity {

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "display")
    private Boolean display;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Power() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
