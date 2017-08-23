package com.tan.authroization.config;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public enum AuthroizationEnum {

    OK("000","ok"),NOT_FIND_TOKEN("001","brcpSession not empty"),TIEM_OUT("002","登录超时");

    private String code;
    private String msg;
    AuthroizationEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
