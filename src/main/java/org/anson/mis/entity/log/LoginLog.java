package org.anson.mis.entity.log;

import org.anson.mis.entity.base.BaseEntity;
import org.anson.mis.entity.system.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_login")
public class LoginLog extends BaseEntity {

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "ip")
    private String ip;

    @Column(name = "browser")
    private String browser;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "logoutTime")
    private Date logoutTime;

    @Column(name = "token")
    private String token;

    @Column(name = "is_success")
    private Boolean success;

    public void convertNull2Default(){
        this.convertNullStr2Empty();

        Date nowTime = new Date();

        this.loginTime = this.logoutTime = nowTime;
        this.setLastUpdateTime(nowTime);
        this.success = false;
    }

    /**
     * 将 null 值的 字符串 类型 转成 空字符串
     */
    public void convertNullStr2Empty(){
        if(this.ip == null){
            this.ip = "";
        }

        if(this.browser == null){
            this.browser = "";
        }

        if(this.operatingSystem == null){
            this.operatingSystem = "";
        }

        if(this.token == null){
            this.token = "";
        }
    }

    public LoginLog() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
