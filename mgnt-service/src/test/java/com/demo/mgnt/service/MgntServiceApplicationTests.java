package com.demo.mgnt.service;

import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.dao.userDao.eo.UserEo;
import com.demo.mgnt.dao.util.DtoHelper;
import com.demo.mgnt.service.userService.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MgntServiceApplicationTests {

    @Test
    void contextLoads() {
        UserEo userEo=new UserEo();
        UserRespDtp respDtp = DtoHelper.EoToDto(userEo, UserEo.class, UserRespDtp.class);

        System.out.println(new UserServiceImpl().getUser(111L));
    }

}
