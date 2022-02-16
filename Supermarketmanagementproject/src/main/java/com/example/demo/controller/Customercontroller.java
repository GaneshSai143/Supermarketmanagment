package com.example.demo.controller;


//import java.util.List;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;

import com.example.demo.entity.dto.Userdto;
import com.example.demo.service.impl.Customerserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	@Autowired
	private Customerserviceimpl detailsServiceImpl;
	
	

		@GetMapping
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
		@GetMapping("/getproducts")
	    public List<Products> getProducts() {
	        return detailsServiceImpl.getAllproducts();
	    }
		
		@GetMapping("/getoutlets")
	    public List<Outlet> getOutlets() {
	        return detailsServiceImpl.getAlloutlets();
	    }
		@GetMapping(value="/{id}")
		public ResponseEntity<User> getUserById(@Valid @PathVariable int id) {
			return ResponseEntity.ok().body(detailsServiceImpl.getUserById(id));
		}
		
		
		
		@PutMapping("/{id}")
		public ResponseEntity<User> update(@Valid @RequestBody Userdto users,@PathVariable int id) {
			users.setId(id);
			
			return ResponseEntity.ok().body(detailsServiceImpl.update(users));
			}
			
		
		
			@DeleteMapping("/{id}")
			public void deleteusers(@Valid @PathVariable int id) {
				detailsServiceImpl.delete(id);
			}
		
	        
		}
	    

