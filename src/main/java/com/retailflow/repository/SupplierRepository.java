package com.retailflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retailflow.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}