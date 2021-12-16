package com.example.demo.controller;


//import java.util.List;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;

import com.example.demo.entity.dto.Userdto;
import com.example.demo.service.impl.Customerserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class Customercontroller {
	
	@Autowired
	private Customerserviceimpl detailsServiceImpl;
	
	

		@GetMapping(value="/user")
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
		@GetMapping(value="/user/{id}")
		public ResponseEntity<User> getUserById(@Valid @PathVariable int id) {
			return ResponseEntity.ok().body(detailsServiceImpl.getUserById(id));
		}
		
	/*	@RequestMapping(value="/user",method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public ResponseEntity<User> create(@Valid @RequestBody Userdto user) throws Exception {
	        detailsServiceImpl.create(user);
	        HttpHeaders headers = new HttpHeaders();
	        
	        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();u
	           
		}*/
		
		
		
		
		@PutMapping("/edit/{id}")
		public ResponseEntity<User> update(@Valid @RequestBody Userdto users,@PathVariable int id) {
			users.setId(id);
			
			return ResponseEntity.ok().body(detailsServiceImpl.update(users));
			}
			
		
		
			@DeleteMapping("/delete/{id}")
			public void deleteusers(@Valid @PathVariable ("id") int id) {
				detailsServiceImpl.delete(id);
			}
		
	        
		}
	    

