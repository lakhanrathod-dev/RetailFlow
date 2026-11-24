package com.retailflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retailflow.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}