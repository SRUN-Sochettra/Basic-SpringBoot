package com.example.basicspringboot.repository;

import com.example.basicspringboot.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepo {

    @Select("""
        SELECT 
            user_id AS userId,
            username,
            password,
            role
        FROM users
        WHERE username = #{username}
    """)
    User findByUsername(String username);

    @Insert("""
        INSERT INTO users(username, password, role)
        VALUES (#{username}, #{password}, #{role})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    void createUser(User user);

    @Select("""
        SELECT COUNT(*) FROM users
    """)
    int countUsers();
}