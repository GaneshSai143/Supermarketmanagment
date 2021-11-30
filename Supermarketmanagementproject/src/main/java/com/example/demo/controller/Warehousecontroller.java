package com.example.demo.controller;


//import java.util.List;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.example.demo.service.impl.UserDetailsServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Warehousecontroller {
	
	private static final Logger log = LoggerFactory.getLogger(Warehousecontroller.class);
	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl; 
	
	@Autowired
	
	 private  ApplicationEventPublisher publisher;
		
	public static final String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";
    public static final String ROLE_OUTLET_ADMIN = "ROLE_OUTLET_ADMIN";
    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    

		@GetMapping(value="/user")
	    public List<User> getAll() {
	        return detailsServiceImpl.getAll();
	    }
		
		@RequestMapping(value="/user",method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public ResponseEntity<?> create(@RequestBody User user) throws Exception {
	        detailsServiceImpl.create(user);
	        HttpHeaders headers = new HttpHeaders();
	        
	        return new ResponseEntity<>(headers, HttpStatus.FOUND);
	           
		}
		
		
		
		
		@PutMapping("/edit/{id}")
		private User update(@RequestBody User users,@PathVariable int id) {
			users.setId(id);
			detailsServiceImpl.update(users);
				return users;
			}
			
		
		
			@DeleteMapping("delete/{id}")
			private void deleteusers(@PathVariable ("id") int id) {
				detailsServiceImpl.delete(id);
			}
		
	        
		}
	    

