package com.demo.mgnt.api.userApi;

import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import org.springframework.web.bind.annotation.*;

/**
 *    token
 */
@RequestMapping("/v1/user")
@RestController
public interface TokenController {

    //通过token获取用户信息
    @GetMapping("")
    UserRespDtp getUserByToken(@RequestParam("token") String token);

    //刷新token
    @PutMapping("/resetToken")
    UserRespDtp resetToken(@RequestBody UserReqDto userReqDto);

    //通过用户名密码获取token
    @PostMapping("/getTokenByUser")
    String getTokenByUser(@RequestBody UserReqDto userReqDto);

}
