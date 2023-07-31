package com.restapi.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductName(String productName);
}
