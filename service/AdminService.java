package com.campus.service;

import com.campus.entity.Order;
import com.campus.entity.Product;
import com.campus.entity.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    List<User> getUsersByRole(Integer role);
    boolean updateUserStatus(Long id, Integer status);
    boolean deleteUser(Long id);
    List<Product> getAllProducts();
    boolean updateProductStatus(Long id, Integer status);
    boolean deleteProduct(Long id);
    List<Order> getAllOrders();
}