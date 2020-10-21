package com.demo.mgnt.dao.userDao;

import com.demo.mgnt.dao.userDao.eo.UserEo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM v1_user where id=#{userId}")
    UserEo getUser(@Param("userId") Long id);
}
