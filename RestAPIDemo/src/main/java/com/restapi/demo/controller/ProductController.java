package com.restapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.entity.Product;
import com.restapi.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
		
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.getProducts();
		
	}
	
	@GetMapping("/productById/{productId}")
	public Product findProductById(@PathVariable Integer productId) {
		
		return productService.getProductById(productId);
		
	}
	
	@GetMapping("/productByName/{productName}")
	public Product findProductByName(@PathVariable String productName) {
		return productService.getProductByName(productName);
		
	}
	
	@PutMapping("/update/{productId}")
	public Product updateProduct(@RequestBody Product productId) {
		return productService.updateProduct(productId);
		
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		return productService.deleteProduct(productId);
		
	}
}