package com.demo.mgnt.service.userService.impl;

import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.dao.userDao.UserMapper;
import com.demo.mgnt.dao.userDao.eo.UserEo;
import com.demo.mgnt.dao.util.DtoHelper;
import com.demo.mgnt.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserRespDtp getUser(Long id) {
        UserEo userEo = userMapper.getUser(id);
        UserRespDtp userRespDtp = DtoHelper.EoToDto(userEo, UserEo.class, UserRespDtp.class);
        return userRespDtp;
    }
}
