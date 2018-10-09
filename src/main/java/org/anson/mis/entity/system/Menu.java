package org.anson.mis.entity.system;

import org.anson.mis.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Menu extends BaseEntity {

    /**
     * 父级菜单
     */
    private Menu parentMenu;

    /**
     * 菜单编码
     */
    private String no;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String iconUrl;

    /**
     * 是否是目录
     */
    @Column(name = "isContent")
    private Boolean content;

    /**
     * 层级, 0为根, 依次增加
     */
    private Integer level;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否显示
     */
    @Column(name = "isDisplay")
    private Boolean display;

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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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
