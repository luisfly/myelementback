package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from tUser where sUserNO = #{userNO}")
    User getUser(@Param("userNO") String userNO);

    public void insert(User user);
    public User getById(int id);
    public void update(User user);
    public void deleteById(int id);


}
