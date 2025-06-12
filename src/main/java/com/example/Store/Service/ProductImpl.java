package com.example.Store.Service;

import com.example.Store.Modules.Product;
import com.example.Store.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductServiceI{
    public final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productCode) {
        return productRepository.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
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
}
