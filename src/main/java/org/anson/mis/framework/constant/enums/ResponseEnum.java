package org.anson.mis.framework.constant.enums;

public enum ResponseEnum {

    /**
     * 200 ok
     */
    OK("200"),

    /**
     * 404 not found
     */
    NOT_FOUND("404"),

    /**
     * 无权限访问接口
     */
    UNAUTHORIZED("430"),

    /**
     * token已过期
     */
    TOKEN_EXPIRED("451"),

    /**
     * refreshtoken已过期
     */
    REFRESH_TOKEN_EXPIRED("452"),

    /**
     * token未过期
     */
    TOKEN_UNEXPIRED("453"),

    /**
     * 客户端错误
     */
    CLIENT_ERROR("499"),

    /**
     * 服务器错误
     */
    SERVER_ERROR("599");

    private String code;

    private ResponseEnum(String code) {
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
