package com.example.Store.Service;

import com.example.Store.Modules.Productline;
import com.example.Store.Repository.ProductlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductlineImpl implements ProductlineServiceI{
    public final ProductlineRepository productlineRepository;

    @Override
    public Productline createProductline(Productline productline) {

        return productlineRepository.save(productline);
    }

    @Override
    public Productline updateProductline(Long productLine, Productline updatedProductline) {
        Productline existingProductline = productlineRepository.findById(productLine)
                .orElseThrow(() -> new RuntimeException("Productline not found"));
        // Update fields (add more as needed)
        existingProductline.setTextDescription(updatedProductline.getTextDescription());
        existingProductline.setHtmlDescription(updatedProductline.getHtmlDescription());
        existingProductline.setImage(updatedProductline.getImage());
        return productlineRepository.save(existingProductline);
    }

    @Override
    public void deleteProductline(Long productLine) {
        productlineRepository.deleteById(productLine);
    }

    @Override
    public List<Productline> getAllProductlines() {
        return productlineRepository.findAll();
    }

}
