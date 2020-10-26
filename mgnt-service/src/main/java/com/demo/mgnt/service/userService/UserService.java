package com.demo.mgnt.service.userService;

import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.github.pagehelper.PageInfo;


public interface UserService {

    //通过id获取user信息
    UserRespDto getUserById(Long id);

    //分页获取用户信息
    PageInfo<UserRespDto> getAllUser(Integer pageSize, Integer pageNum);

    //通过token获取用户信息
    UserRespDto getUserByToken(String token);

    //通过用户id更新token
    void updateTokenById(Long userId,String token);
}
