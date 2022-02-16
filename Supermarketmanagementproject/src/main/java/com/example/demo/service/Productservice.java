package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Products;
import com.example.demo.entity.dto.Productdto;



public interface Productservice {

	public List<Products> getAll();
	public Products create(Productdto user) ;
		
		public Products update(Productdto user);
		
		 public void delete(int id);
		 Products getProductById(int id);
		List<Products> getproducts();
		
}
