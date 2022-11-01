package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.productRepo;
@Service
public class Productservice {

	@Autowired
	productRepo repo;
	
	public List<Product> saveProducts(List<Product> product) {
		// TODO Auto-generated method stub
		return repo.saveAll(product);
	}

	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
