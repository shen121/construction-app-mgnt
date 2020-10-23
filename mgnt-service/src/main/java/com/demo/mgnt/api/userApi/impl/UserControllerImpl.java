package com.demo.mgnt.api.userApi.impl;

import com.demo.mgnt.api.userApi.UserController;
import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.demo.mgnt.api.util.RestResponse;
import com.demo.mgnt.service.userService.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public RestResponse<UserRespDto> getUserById(Long id) {
        return new RestResponse<>(userService.getUserById(id));
    }

    @Override
    public RestResponse<PageInfo<UserRespDto>> getAllUser(Integer pageSize, Integer pageNum) {
        return new RestResponse<>(userService.getAllUser(pageSize,pageNum));
    }

}
