package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from tUser where sUserNO = #{userNO}")
    User getUser(@Param("userNO") String userNO);

    public boolean insert(User user);
    public User getById(int id);
    public boolean update(User user);
    public boolean deleteById(int id);

}
