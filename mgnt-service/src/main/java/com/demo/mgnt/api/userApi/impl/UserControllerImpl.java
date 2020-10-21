package com.demo.mgnt.api.userApi.impl;

import com.demo.mgnt.api.userApi.UserController;
import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.api.config.util.RestResponse;
import com.demo.mgnt.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public RestResponse<UserRespDtp> getUser(Long id) {
        return new RestResponse<>(userService.getUser(id));
    }
}
