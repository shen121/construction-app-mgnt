package com.demo.mgnt.api.userApi;

import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.api.util.RestResponse;
import org.springframework.web.bind.annotation.*;

/**
 *    token
 */
@RequestMapping("/v1/token")
public interface TokenController {

    //通过token获取用户信息
    @GetMapping("")
    RestResponse<UserRespDtp> getUserByToken(@RequestParam("token") String token);

    //刷新token
    @PutMapping("/resetToken")
    RestResponse<String> resetToken(@RequestBody UserReqDto userReqDto);

    //通过用户名密码获取token
    @PostMapping("/getTokenByUser")
    RestResponse<String> getTokenByUser(@RequestBody UserReqDto userReqDto);

}
