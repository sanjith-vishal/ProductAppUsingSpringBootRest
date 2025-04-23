package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
    @Autowired
	ProductService service;
 
	@GetMapping("/getMsg") // http://localhost:1111/products/getMsg
	public String sayHello() {
		return "am need break trying to listen but am getting sleep";
	}
 
	@PostMapping("/saveproduct") // http://localhost:1111/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
	
	@PutMapping("/updateproduct") // http://localhost:1111/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getproduct/{pid}") // http://localhost:1111/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	
	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1111/products/deleteproduct/1
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	@GetMapping("/getAllProducts") // http://localhost:1111/products/getAllProducts
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getproduct/{price1}/{price2}") // http://localhost:1111/products/getproductbetween/2000/5500
	public List<Product> fetchProductsBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice) ;
	}
	
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
 
	
}