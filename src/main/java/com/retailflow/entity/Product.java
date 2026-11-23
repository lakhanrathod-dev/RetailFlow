package com.retailflow.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	@Column(nullable = false, unique = true)
	private String sku;
	private String category;
	private BigDecimal unitPrice;
	private int reorderLevel;
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
}