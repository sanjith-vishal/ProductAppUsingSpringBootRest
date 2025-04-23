package com.cts.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "product_info")
@Data
public class Product {
	@Id
	@Column(name = "pId")
	@GeneratedValue
	private int productId;
	@NotBlank(message = "ProductName cant be NULL or BLANK") // will not allow " "
	// @NotNull
	// @NotEmpty //will now allow "", but will allow " "
	private String productName;
	@Column(name = "price")
	@Min(value = 100, message = "ProductPrice can't be less than 100")
	@Max(value = 100000, message = "ProductPrice can't be more than 100000")
	private int productPrice;
	@Size(min=5, max=12, message="Category length must be (5, 12) ")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="Quantity cannot be Zero or -ve")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {

		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public Product() {
	}

}
