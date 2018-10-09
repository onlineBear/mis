package org.anson.mis.entity.system;

import org.anson.mis.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_menu")
public class Menu extends BaseEntity {

    /**
     * 父级菜单
     */
    @ManyToOne(cascade = {CascadeType.PERSIST}, optional = true)
    @JoinColumn(name = "parent_menu_id")
    private Menu parentMenu;

    /**
     * 菜单编码
     */
    @Column(name = "no")
    private String no;

    /**
     * 菜单名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 是否是目录
     */
    @Column(name = "is_content")
    private Boolean content;

    /**
     * 层级, 0为根, 依次增加
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 是否显示
     */
    @Column(name = "is_display")
    private Boolean display;

    @OneToMany(mappedBy = "parentMenu", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Menu> menuSet;

    public Menu() {
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getContent() {
        return content;
    }

    public void setContent(Boolean content) {
        this.content = content;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }
}
