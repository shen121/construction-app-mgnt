package com.demo.mgnt.service.userService;

import com.demo.mgnt.api.userApi.respDto.UserRespDto;
import com.github.pagehelper.PageInfo;


public interface UserService {

    UserRespDto getUserById(Long id);

    PageInfo<UserRespDto> getAllUser(Integer pageSize, Integer pageNum);
}
