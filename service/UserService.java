package com.campus.service;

import com.campus.entity.User;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);
    User getUserById(Long id);
    boolean updateUser(User user);
    boolean deleteUser(Long id);
}