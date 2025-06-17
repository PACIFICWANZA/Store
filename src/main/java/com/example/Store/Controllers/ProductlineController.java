package com.example.Store.Controllers;

import com.example.Store.Modules.Productline;
import com.example.Store.Service.ProductlineServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productline")
@RequiredArgsConstructor
public class ProductlineController {

    public final ProductlineServiceI productlineServiceI;

    @PostMapping("/saveProductLine")
    public ResponseEntity<String> saveProductLine(@RequestBody Productline productLine){
        try{
            productlineServiceI.createProductline(productLine);
            return ResponseEntity.ok("Productline saved successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/viewProductLines")
    public ResponseEntity<List<Productline>> getAllProductlines() {
        try {
            List<Productline> productlines = productlineServiceI.getAllProductlines();
            return ResponseEntity.ok(productlines);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateProductLine/{productLine}")
    public ResponseEntity<?> updateProductLine(@PathVariable Long productLine, @RequestBody Productline productline){
        try{
            Productline updatedProductline = productlineServiceI.updateProductline(productLine, productline);
            return ResponseEntity.ok(updatedProductline);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteProductLine/{productLine}")
    public ResponseEntity<Void> deleteProductLine(@PathVariable Long productLine){
        try{
            productlineServiceI.deleteProductline(productLine);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    }
