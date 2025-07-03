package com.example.Store.Service;

import com.example.Store.Modules.Product;
import com.example.Store.Modules.Productline;
import com.example.Store.Repository.ProductRepository;
import com.example.Store.Repository.ProductlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductServiceI{
    public final ProductRepository productRepository;
    public final ProductlineRepository productlineRepository;

    @Override
    public Product createProduct(Product product) {
        // Fetch the Productline entity using the ID from the incoming Product
        Productline productline = productlineRepository.findById(product.getProductLine().getProductLine())
                .orElseThrow(() -> new RuntimeException("Productline not found"));
        product.setProductLine(productline);
        return productRepository.save(product);
    }



    @Override
    public Product updateProduct(Long productCode, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        // Update fields (add more as needed)
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductScale(updatedProduct.getProductScale());
        existingProduct.setProductVendor(updatedProduct.getProductVendor());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());
        existingProduct.setQuantityInStock(updatedProduct.getQuantityInStock());
        existingProduct.setBuyPrice(updatedProduct.getBuyPrice());
        existingProduct.setMSRP(updatedProduct.getMSRP());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productCode) {

        productRepository.deleteById(productCode);
    }

    public long countProducts() {
        return productRepository.count();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
