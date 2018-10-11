package org.anson.mis.framework.jwt.entity;

import java.util.Date;

/**
 * jwt 实体
 */
public class JwtEntity {
    /**
     * 颁发者
     */
    private String issuer;

    /**
     * 主题
     */
    private String subject;

    /**
     * 客户
     */
    private String audience;

    /**
     * token 过期时间
     */
    private Date tokenExpiredTime;

    /**
     * 刷新token 过期时间
     */
    private Date refreshTokenTTL;

    /**
     * 登录用户编码
     */
    private String userNo;

    public JwtEntity() {
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Long getTokenTTL() {
        return tokenTTL;
    }

    public void setTokenTTL(Long tokenTTL) {
        this.tokenTTL = tokenTTL;
    }

    public Long getRefreshTokenTTL() {
        return refreshTokenTTL;
    }

    public void setRefreshTokenTTL(Long refreshTokenTTL) {
        this.refreshTokenTTL = refreshTokenTTL;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
