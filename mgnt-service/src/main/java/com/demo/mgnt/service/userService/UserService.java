package com.demo.mgnt.service.userService;

import com.demo.mgnt.api.userApi.respDto.UserRespDtp;

public interface UserService {

    UserRespDtp getUser(Long id);
}
