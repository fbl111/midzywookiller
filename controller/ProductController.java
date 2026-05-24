package com.campus.controller;

import com.campus.entity.Product;
import com.campus.service.ProductService;
import com.campus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Result<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return Result.success(product);
        }
        return Result.error("商品不存在");
    }

    @GetMapping
    public Result<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Result.success(products);
    }

    @GetMapping("/category/{category}")
    public Result<List<Product>> getProductsByCategory(@PathVariable Integer category) {
        List<Product> products = productService.getProductsByCategory(category);
        return Result.success(products);
    }

    @GetMapping("/seller/{sellerId}")
    public Result<List<Product>> getProductsBySellerId(@PathVariable Long sellerId) {
        List<Product> products = productService.getProductsBySellerId(sellerId);
        return Result.success(products);
    }

    @PostMapping
    public Result<Boolean> addProduct(@RequestBody Product product) {
        boolean success = productService.addProduct(product);
        if (success) {
            return Result.success(true);
        }
        return Result.error("发布失败");
    }

    @PutMapping("/{id}")
    public Result<Boolean> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        boolean success = productService.updateProduct(product);
        if (success) {
            return Result.success(true);
        }
        return Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteProduct(@PathVariable Long id) {
        boolean success = productService.deleteProduct(id);
        if (success) {
            return Result.success(true);
        }
        return Result.error("删除失败");
    }
}