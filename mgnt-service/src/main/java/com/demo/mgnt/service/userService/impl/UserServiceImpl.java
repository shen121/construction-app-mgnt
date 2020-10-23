package com.demo.mgnt.service.userService.impl;

import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.demo.mgnt.dao.userDao.UserMapper;
import com.demo.mgnt.dao.userDao.eo.UserEo;
import com.demo.mgnt.dao.util.DtoHelper;
import com.demo.mgnt.service.userService.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserRespDto getUserById(Long id) {
        UserEo userEo = userMapper.getUserById(id);
        UserRespDto userRespDtp = DtoHelper.EoToDto(userEo, UserEo.class, UserRespDto.class);
        return userRespDtp;
    }

    @Override
    public PageInfo<UserRespDto> getAllUser(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEo> userEoList = userMapper.getAllUser();
        PageInfo<UserEo> pageInfo= new PageInfo<>(userEoList);

        List<UserRespDto> userRespDtoList=DtoHelper.EoListToDtoList(userEoList,UserEo.class,UserRespDto.class);
        PageInfo<UserRespDto> respPageInfo=new PageInfo<>();

        BeanUtils.copyProperties(pageInfo,respPageInfo);
        respPageInfo.setList(userRespDtoList);

        return respPageInfo;
    }
}
