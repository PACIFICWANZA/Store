package com.example.Store.Service;

import com.example.Store.Modules.Productline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductlineServiceI {
    Productline createProductline(Productline productline);
    List<Productline> getAllProductlines();
    Productline updateProductline(Long productLine, Productline productline);
    void deleteProductline(Long productLine);

}
