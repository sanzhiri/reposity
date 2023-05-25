package com.sql.mapper;

import com.sql.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Select("SELECT * FROM users WHERE id=#{id}")
    User getUserById(Long id);

    @Insert("INSERT INTO users(name, email, password) VALUES(#{name}, #{email}, #{password})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insertUser(User user);

    @Update("UPDATE users SET name=#{name}, email=#{email} WHERE id=#{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void deleteUser(Long id);
}