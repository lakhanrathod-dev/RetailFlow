
package com.retailflow.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.retailflow.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	// Find inventory by product ID
	Optional<Inventory> findByProductId(Long productId);

	// Find products that have reached their reorder level
	@Query("SELECT i FROM Inventory i WHERE i.availableQuantity <= i.reorderLevel")
	List<Inventory> findLowStockProducts();
}
