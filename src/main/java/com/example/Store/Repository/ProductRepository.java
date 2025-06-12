package com.example.Store.Repository;

import com.example.Store.Modules.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
