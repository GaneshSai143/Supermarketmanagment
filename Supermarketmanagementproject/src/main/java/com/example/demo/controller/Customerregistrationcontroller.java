package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.service.impl.Customerserviceimpl;
import com.example.demo.service.impl.Customerserviceregisterserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customerregister")
public class Customerregistrationcontroller {

	@Autowired
	private Customerserviceregisterserviceimpl detailsServiceImpl;
	
	@PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<User> create(@Valid @RequestBody Userdto user) throws Exception {
        detailsServiceImpl.create(user);
        HttpHeaders headers = new HttpHeaders();
        
        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
           
	}
}
