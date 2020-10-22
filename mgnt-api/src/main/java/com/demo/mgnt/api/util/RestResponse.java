package com.demo.mgnt.api.util;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private String restCode;
    private String restMsg;
    private T data;

    public static String DEFAULT_SUCCESS_CODE="00000";
    public static String DEFAULT_SUCCESS_MSG="成功";

    public static String DEFAULT_ERROR_CODE="00001";
    public static String DEFAULT_ERROR_MSG="失败";

    public RestResponse(){
        this.restMsg=DEFAULT_SUCCESS_MSG;
        this.restCode=DEFAULT_SUCCESS_CODE;
    }
    public RestResponse(T data){
        this.restMsg=DEFAULT_SUCCESS_MSG;
        this.restCode=DEFAULT_SUCCESS_CODE;
        this.data=data;
    }
    public RestResponse(String restCode,String restMsg){
        this.restCode=restCode;
        this.restMsg=restMsg;
    }
    public RestResponse(String restCode,String restMsg,T data){
        this.restCode=restCode;
        this.restMsg=restMsg;
        this.data=data;
    }



    public String getRestCode() {
        return restCode;
    }

    public void setRestCode(String restCode) {
        this.restCode = restCode;
    }

    public String getRestMsg() {
        return restMsg;
    }

    public void setRestMsg(String restMsg) {
        this.restMsg = restMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
