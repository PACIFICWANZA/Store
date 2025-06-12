package com.example.Store.Controllers;

import com.example.Store.Modules.Product;
import com.example.Store.Service.ProductServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    public final ProductServiceI productServiceI;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        try{
            productServiceI.createProduct(product);
            return ResponseEntity.ok("Product saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
    @GetMapping("/viewProduct/{productCode}")
    public ResponseEntity<?> viewProduct(@PathVariable Long productCode){
        try{
            Product product = productServiceI.getProduct(productCode);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/updateProduct/{productCode}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productCode, @RequestBody Product product){
        try{
           Product updatedProduct = productServiceI.updateProduct(productCode, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteProduct/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productCode){
        try{
            productServiceI.deleteProduct(productCode);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
