package com.demo.mgnt.dao.userDao;

import com.demo.mgnt.dao.userDao.eo.UserEo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM v1_user where id=#{userId} ")
    UserEo getUserById(@Param("userId") Long id);

    @Select("SELECT * FROM v1_user ")
    List<UserEo> getAllUser();

    @Select("SELECT * FROM v1_user where current_token=#{token} limit 1 ")
    UserEo getUserByToken(@Param("token") String token);

    @Update("update v1_user set current_token=#{token} where id=#{userId} ")
    void updateTokenById(@Param("userId") Long userId, @Param("token") String token);
}
