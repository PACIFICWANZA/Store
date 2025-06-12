package com.example.Store.Service;

import com.example.Store.Modules.Productline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface ProductlineServiceI {
    Productline createProductline(Productline productline);
    Productline getProductline(Long productLine);
    Productline updateProductline(Long productLine, Productline productline);
    void deleteProductline(Long productLine);
}
