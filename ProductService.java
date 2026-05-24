package com.campus.service;

import com.campus.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Integer category);
    List<Product> getProductsBySellerId(Long sellerId);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Long id);
}