package com.campus.controller;

import com.campus.entity.Order;
import com.campus.entity.Product;
import com.campus.entity.User;
import com.campus.service.AdminService;
import com.campus.service.OrderService;
import com.campus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/users")
    public Result<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return Result.success(users);
    }

    @GetMapping("/users/role/{role}")
    public Result<List<User>> getUsersByRole(@PathVariable Integer role) {
        List<User> users = adminService.getUsersByRole(role);
        return Result.success(users);
    }

    @PutMapping("/users/{id}/status")
    public Result<Boolean> updateUserStatus(@PathVariable Long id, @RequestParam Integer status) {
        boolean success = adminService.updateUserStatus(id, status);
        if (success) {
            return Result.success(true);
        }
        return Result.error("更新用户状态失败");
    }

    @DeleteMapping("/users/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        boolean success = adminService.deleteUser(id);
        if (success) {
            return Result.success(true);
        }
        return Result.error("删除用户失败");
    }

    @GetMapping("/products")
    public Result<List<Product>> getAllProducts() {
        List<Product> products = adminService.getAllProducts();
        return Result.success(products);
    }

    @PutMapping("/products/{id}/status")
    public Result<Boolean> updateProductStatus(@PathVariable Long id, @RequestParam Integer status) {
        boolean success = adminService.updateProductStatus(id, status);
        if (success) {
            return Result.success(true);
        }
        return Result.error("更新商品状态失败");
    }

    @DeleteMapping("/products/{id}")
    public Result<Boolean> deleteProduct(@PathVariable Long id) {
        boolean success = adminService.deleteProduct(id);
        if (success) {
            return Result.success(true);
        }
        return Result.error("删除商品失败");
    }

    @GetMapping("/orders")
    public Result<List<Order>> getAllOrders() {
        List<Order> orders = adminService.getAllOrders();
        return Result.success(orders);
    }
}