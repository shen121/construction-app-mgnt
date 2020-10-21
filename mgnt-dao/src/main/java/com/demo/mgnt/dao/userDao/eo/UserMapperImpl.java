package com.demo.mgnt.dao.userDao.eo;

import com.demo.mgnt.dao.userDao.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    public UserEo getUser(Long id) {
        return new UserEo();
    }
}
