package com.campus.service.impl;

import com.campus.entity.Order;
import com.campus.entity.Product;
import com.campus.entity.User;
import com.campus.mapper.OrderMapper;
import com.campus.mapper.ProductMapper;
import com.campus.mapper.UserMapper;
import com.campus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getUsersByRole(Integer role) {
        return userMapper.selectByRole(role);
    }

    @Override
    public boolean updateUserStatus(Long id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.selectAll();
    }

    @Override
    public boolean updateProductStatus(Long id, Integer status) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(status);
        return productMapper.update(product) > 0;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productMapper.deleteById(id) > 0;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.selectAll();
    }
}