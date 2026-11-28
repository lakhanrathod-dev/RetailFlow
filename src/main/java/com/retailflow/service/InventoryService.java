package com.retailflow.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retailflow.entity.Inventory;
import com.retailflow.entity.Product;
import com.retailflow.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	// Get all inventory records
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	// Get inventory by product ID
	public Inventory getInventoryByProductId(Long productId) {
		return inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new RuntimeException("Inventory not found"));
	}

	// Increase stock after GRN approval
	@Transactional
	public Inventory increaseStock(Product product, int quantity) {
		Inventory inventory = inventoryRepository.findByProductId(product.getId()).orElseGet(() -> {
			Inventory newInventory = new Inventory();
			newInventory.setProduct(product);
			newInventory.setAvailableQuantity(0);
			newInventory.setReorderLevel(product.getReorderLevel());
			return newInventory;
		});
		inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
		return inventoryRepository.save(inventory);
	}

	public List<Inventory> getLowStockProducts() {
		return inventoryRepository.findLowStockProducts();
	}
}
