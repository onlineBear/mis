package org.anson.mis.framework.exception.entity;

import org.anson.mis.framework.constant.enums.ResponseEnum;

/**
 * 客户端异常
 */
public class ClientException extends Exception {
    private ResponseEnum code = ResponseEnum.CLIENT_ERROR;
    private String msg;

    public ClientException() {
    }

    public ClientException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseEnum getCode(){
        return code;
    }
}
