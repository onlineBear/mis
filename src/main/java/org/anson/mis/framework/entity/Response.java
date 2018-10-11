package org.anson.mis.framework.entity;

import org.anson.mis.framework.constant.enums.ResponseEnum;

/**
 * web 响应类
 */
public class Response {
    /**
     * code
     */
    private ResponseEnum code;

    /**
     * data
     */
    private Object data;

    /**
     * msg
     */
    private String msg;

    public static Response ok(){
        return new Response(ResponseEnum.OK, null, null);
    }

    public static Response ok(Object data){
        return new Response(ResponseEnum.OK, data, null);
    }

    public static Response clienError(String msg){
        return new Response(ResponseEnum.CLIENT_ERROR, null, msg);
    }

    public static Response serverError(String msg){
        return new Response(ResponseEnum.SERVER_ERROR, null, msg);
    }

    public Response() {
    }

    public Response(ResponseEnum code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResponseEnum getCode() {
        return code;
    }

    public void setCode(ResponseEnum code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
