package com.example.Store.Service;

import com.example.Store.Modules.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceI {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(Long productCode, Product product);
    void deleteProduct(Long productCode);
    long countProducts();

}
