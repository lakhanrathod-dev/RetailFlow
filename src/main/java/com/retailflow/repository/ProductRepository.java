package com.retailflow.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.retailflow.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}