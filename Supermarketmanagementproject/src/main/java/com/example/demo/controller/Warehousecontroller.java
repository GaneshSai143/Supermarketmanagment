package com.example.demo.controller;


//import java.util.List;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.service.impl.UserDetailsServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Warehousecontroller {
	
	private static final Logger log = LoggerFactory.getLogger(Warehousecontroller.class);
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl; 
	
	

		@GetMapping(value="/user")
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
		@GetMapping(value="/{id}")
		public ResponseEntity<User> getUserById(@PathVariable int id) {
			return ResponseEntity.ok().body(detailsServiceImpl.getUserById(id));
		}
		
		@RequestMapping(value="/user",method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public ResponseEntity<User> create(@Valid @RequestBody Userdto user) throws Exception {
	        detailsServiceImpl.create(user);
	        HttpHeaders headers = new HttpHeaders();
	        
	        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
	           
		}
		
		
		
		
		@PutMapping("/edit/{id}")
		public ResponseEntity<User> update(@RequestBody Userdto users,@PathVariable int id) {
			users.setId(id);
			
			return ResponseEntity.ok().body(detailsServiceImpl.update(users));
			}
			
		
		
			@DeleteMapping("/delete/{id}")
			public void deleteusers(@PathVariable ("id") int id) {
				detailsServiceImpl.delete(id);
			}
		
	        
		}
	    

