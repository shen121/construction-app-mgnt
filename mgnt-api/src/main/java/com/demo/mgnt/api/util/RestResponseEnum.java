package com.demo.mgnt.api.util;

public enum RestResponseEnum {

    default_success("00000","默认成功"),
    default_error("00001","默认失败"),
    token_error("99999","token 错误");

    private String code;
    private String msg;

    RestResponseEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode(){return code;}

    public String getMsg(){return msg;}
}
