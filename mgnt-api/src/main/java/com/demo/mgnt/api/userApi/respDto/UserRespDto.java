package com.demo.mgnt.api.userApi.respDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "UserRespDto", description = "UserRespDto对象")
public class UserRespDto implements Serializable {

    @ApiModelProperty(name = "id", value = "ID")
    private Long id;

    @ApiModelProperty(name = "name", value = "姓名")
    private String name;

    @ApiModelProperty(name = "currentToken", value = "当前token")
    private String currentToken;

    @ApiModelProperty(name = "tel", value = "手机号")
    private String tel;

    @ApiModelProperty(name = "areaCode", value = "所在地Code")
    private String areaCode;

    @ApiModelProperty(name = "area", value = "所在地")
    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
