package com.retailflow.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.retailflow.entity.Inventory;
import com.retailflow.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	// Get all inventory records
	@GetMapping
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventory();
	}

	// Get inventory by product ID
	@GetMapping("/product/{productId}")
	public Inventory getInventoryByProductId(@PathVariable Long productId) {

		return inventoryService.getInventoryByProductId(productId);
	}

	@GetMapping("/low-stock")
	public List<Inventory> getLowStockProducts() {
		return inventoryService.getLowStockProducts();
	}
}