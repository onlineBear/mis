package org.anson.mis.framework.auth.token;

/**
 * 登录 token
 */
public class Token {
    /**
     * token
     */
    private String token;

    /**
     * 刷新 token
     */
    private String refreshToken;

    /**
     * 过期时间
     */
    private Long expireMills;

    /**
     * 刷新过期时间
     */
    private Long refreshExpiredMills;

    /**
     * token 是否已刷新
     */
    private Boolean refresh;

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireMills() {
        return expireMills;
    }

    public void setExpireMills(Long expireMills) {
        this.expireMills = expireMills;
    }

    public Long getRefreshExpiredMills() {
        return refreshExpiredMills;
    }

    public void setRefreshExpiredMills(Long refreshExpiredMills) {
        this.refreshExpiredMills = refreshExpiredMills;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }
}
