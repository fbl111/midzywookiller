package com.campus.service.impl;

import com.campus.entity.Product;
import com.campus.mapper.ProductMapper;
import com.campus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> getProductsByCategory(Integer category) {
        return productMapper.selectByCategory(category);
    }

    @Override
    public List<Product> getProductsBySellerId(Long sellerId) {
        return productMapper.selectBySellerId(sellerId);
    }

    @Override
    public boolean addProduct(Product product) {
        product.setStatus(0);
        return productMapper.insert(product) > 0;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productMapper.update(product) > 0;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productMapper.deleteById(id) > 0;
    }
}