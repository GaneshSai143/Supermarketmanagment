package com.example.demo.controller;


//import java.util.List;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserDetailsServiceImpl;




@RestController
public class Warehousecontroller {
	
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl; 
		
		

		@GetMapping(value="/user")
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
		@RequestMapping(value="/user",method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public ResponseEntity<?> create(@RequestBody User user) {
	        detailsServiceImpl.create(user);
	        HttpHeaders headers = new HttpHeaders();
	        return new ResponseEntity<>(headers, HttpStatus.FOUND);
	    }
}
