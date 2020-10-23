package com.demo.mgnt.api.userApi;

import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.demo.mgnt.api.util.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 *    token
 */
@Api(tags = "token管理Api")
@RequestMapping("/v1/token")
public interface TokenController {

    @GetMapping("")
    @ApiOperation(value = "通过token获取用户信息", notes = "通过token获取用户信息")
    RestResponse<UserRespDto> getUserByToken(@RequestParam("token") String token);

    @PutMapping("/resetToken")
    @ApiOperation(value = "刷新token", notes = "刷新token")
    RestResponse<String> resetToken(@RequestBody UserReqDto userReqDto);

    @PostMapping("/getTokenByUser")
    @ApiOperation(value = "通过用户名密码获取token", notes = "通过用户名密码获取token")
    RestResponse<String> getTokenByUser(@RequestBody UserReqDto userReqDto);

}
