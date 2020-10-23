package com.demo.mgnt.dao.userDao;

import com.demo.mgnt.dao.userDao.eo.UserEo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM v1_user where id=#{userId} ")
    UserEo getUserById(@Param("userId") Long id);

    @Select("SELECT * FROM v1_user ")
    List<UserEo> getAllUser();
}
