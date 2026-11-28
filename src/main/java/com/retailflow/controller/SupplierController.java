package com.retailflow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.retailflow.entity.Supplier;
import com.retailflow.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    // Add supplier
    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }
    // Get all suppliers
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
    // Get supplier by ID
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }
 // Update supplier
    @PutMapping("/{id}")
    public Supplier updateSupplier(
            @PathVariable Long id,
            @RequestBody Supplier supplier) {

        return supplierService.updateSupplier(id, supplier);
    }
}