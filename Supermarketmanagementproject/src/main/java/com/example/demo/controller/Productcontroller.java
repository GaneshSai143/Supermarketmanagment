package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Products;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.service.impl.Productserviceimpl;

@RestController
public class Productcontroller {
	
	@Autowired
	private Productserviceimpl pservice;
	
	@GetMapping("/products")
	public List<Products> getallproducts()
	{
		return pservice.getAll();
	}
	
	@PostMapping("/products")
	public ResponseEntity<Products> saveproducts(@RequestBody Productdto user){
		
		
		 pservice.create(user);
		 HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
	}
	
	@GetMapping(value="/product/{id}")
	public ResponseEntity<Products> getUserById(@PathVariable int id) {
		return ResponseEntity.ok().body(pservice.getProductById(id));
	}
	
	@PutMapping(value="/products/{id}")
	public ResponseEntity<Products> update(@RequestBody Productdto items,@PathVariable int id) {
		items.setId(id);
		return ResponseEntity.ok().body(this.pservice.update(items));
		
		}
	
	@DeleteMapping("/productdelete/{id}")
	public void deleteproducts(@PathVariable ("id") int id) {
		pservice.delete(id);
	}


}