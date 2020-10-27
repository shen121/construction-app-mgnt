package com.demo.mgnt.api.userApi.impl;

import com.demo.mgnt.api.userApi.TokenController;
import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.demo.mgnt.api.util.RestResponse;
import com.demo.mgnt.config.util.JwtUtil;
import com.demo.mgnt.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TokenControllerImpl implements TokenController {

    @Autowired
    private UserService userService;

    @Override
    public RestResponse<UserRespDto> getUserByToken(String token) {
        return new RestResponse<>(userService.getUserByToken(token));
    }

    @Override
    public RestResponse<String> generateTokenAndUpdateUser(UserReqDto userReqDto) {
        String token = JwtUtil.sign(userReqDto.getId(), userReqDto.getName());
        userService.updateTokenById(userReqDto.getId(),token);
        return new RestResponse<>(token);
    }
}
