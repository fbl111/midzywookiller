package com.campus.mapper;

import com.campus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectById(Long id);
    User selectByUsername(String username);
    User selectByEmail(String email);
    User selectByPhone(String phone);
    int insert(User user);
    int update(User user);
    int deleteById(Long id);
    List<User> selectAll();
    List<User> selectByRole(Integer role);
    List<User> selectByStatus(Integer status);
}