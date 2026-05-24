package com.campus.controller;

import com.campus.entity.User;
import com.campus.service.UserService;
import com.campus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            return Result.success(loginUser);
        }
        return Result.error(401, "用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody User user) {
        boolean success = userService.register(user);
        if (success) {
            return Result.success(true);
        }
        return Result.error("注册失败");
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户不存在");
    }

    @PutMapping("/{id}")
    public Result<Boolean> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        boolean success = userService.updateUser(user);
        if (success) {
            return Result.success(true);
        }
        return Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        if (success) {
            return Result.success(true);
        }
        return Result.error("删除失败");
    }
}