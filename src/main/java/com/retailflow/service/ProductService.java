package com.retailflow.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.retailflow.entity.Product;
import com.retailflow.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
 // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }
    public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct = getProductById(id);

        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setSku(updatedProduct.getSku());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setUnitPrice(updatedProduct.getUnitPrice());
        existingProduct.setReorderLevel(updatedProduct.getReorderLevel());

        return productRepository.save(existingProduct);
    }
}