package com.ykjava.mapper;

import com.ykjava.modal.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baoz on 2017/3/10.
 */
public interface UserMapper {

    @Insert("insert into user (name, age) values (#{user.name}, #{user.age})")
    void addOne(@Param("user") User user);

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    void addOneRaw(@Param("name") String name, @Param("age") int age);


    @Select("select * from user")
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    User getOne(@Param("id") int id);


    void update(@Param("user") User u);

}
