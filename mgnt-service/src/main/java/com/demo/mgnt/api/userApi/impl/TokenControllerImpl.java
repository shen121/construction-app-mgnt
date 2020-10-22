package com.demo.mgnt.api.userApi.impl;

import com.demo.mgnt.api.userApi.TokenController;
import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.api.util.RestResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenControllerImpl implements TokenController {
    @Override
    public RestResponse<UserRespDtp> getUserByToken(String token) {
        return null;
    }

    @Override
    public RestResponse<String> resetToken(UserReqDto userReqDto) {
        return null;
    }

    @Override
    public RestResponse<String> getTokenByUser(UserReqDto userReqDto) {
        return null;
    }
}
