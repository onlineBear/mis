package org.anson.mis.framework.exception.entity;


import org.anson.mis.framework.constant.enums.ResponseEnum;

/**
 * 服务端异常
 */
public class ServerException extends Exception{
    private static final ResponseEnum code = ResponseEnum.SERVER_ERROR;
    private String msg;

    public ServerException() {
    }

    public ServerException(String msg){
        this.msg = msg;
    }

    public ResponseEnum getCode() {
        return ServerException.code;
    }

    public String getMsg() {
        return msg;
    }
}
