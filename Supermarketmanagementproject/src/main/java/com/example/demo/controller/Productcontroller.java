package com.example.demo.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Products;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.service.impl.Productserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class Productcontroller {
	
	@Autowired
	private Productserviceimpl pservice;
	
	@GetMapping("/get")
	public List<Products> getallproducts()
	{
		return pservice.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Productdto> saveproducts(@Valid @RequestBody Productdto user){

		 pservice.create(user);
		 HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Products>(headers, HttpStatus.FOUND).ok().build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Products> getUserById(@Valid @PathVariable int id) {
		return ResponseEntity.ok().body(pservice.getProductById(id));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Products> update(@Valid @RequestBody Productdto items,@PathVariable int id) {
		items.setId(id);
		return ResponseEntity.ok().body(this.pservice.update(items));
		
		}
	
	@DeleteMapping("/{id}")
	public void deleteproducts(@Valid @PathVariable int id) {
		pservice.delete(id);
	}


}
