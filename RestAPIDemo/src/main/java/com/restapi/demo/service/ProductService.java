package com.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.entity.Product;
import com.restapi.demo.exception.NoProductFoundException;
import com.restapi.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);

	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);

	}

	public List<Product> getProducts() {
		return productRepository.findAll();

	}

	public Product getProductById(Integer productId) {
		return productRepository.findById(productId).orElseThrow(()->new NoProductFoundException("Product", "productId",productId));

	}

	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);

	}

	public String deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		return "Product removed " + productId;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductQuantity(product.getProductQuantity());
		existingProduct.setProductPrice(product.getProductPrice());
		return productRepository.save(existingProduct);
	}

}
