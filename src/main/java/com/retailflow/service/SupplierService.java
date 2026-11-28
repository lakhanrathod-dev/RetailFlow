package com.retailflow.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.retailflow.entity.Supplier;
import com.retailflow.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    // Add supplier
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    // Get all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    // Get supplier by ID
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Supplier not found with ID: " + id));
    }
 // Update supplier
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {

        Supplier existingSupplier = getSupplierById(id);

        existingSupplier.setSupplierName(updatedSupplier.getSupplierName());
        existingSupplier.setEmail(updatedSupplier.getEmail());
        existingSupplier.setPhone(updatedSupplier.getPhone());
        existingSupplier.setAddress(updatedSupplier.getAddress());
        existingSupplier.setCity(updatedSupplier.getCity());

        return supplierRepository.save(existingSupplier);
    }
}