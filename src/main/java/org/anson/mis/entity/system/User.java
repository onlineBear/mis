package org.anson.mis.entity.system;

import org.anson.mis.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class User extends BaseEntity {

    /**
     * 用户编码
     */
    @Column(name = "no")
    private String no;

    /**
     * 用户名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 头像
     */
    @Column(name = "profile_photo")
    private String profilePhoto;

    /**
     * 个人说明
     */
    @Column(name = "personal_statement")
    private String personalStatement;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPersonalStatement() {
        return personalStatement;
    }

    public void setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
    }
}
