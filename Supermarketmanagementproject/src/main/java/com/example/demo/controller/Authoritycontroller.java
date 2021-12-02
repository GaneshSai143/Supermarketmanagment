package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Authority;
import com.example.demo.service.impl.Authorityserviceimpl;

@RestController
public class Authoritycontroller {

	
	@Autowired
	private Authorityserviceimpl authservice;
	
	@PostMapping
	public ResponseEntity<Authority> saveRole(@RequestBody Authority authority) {
	
	
	   Authority neAuthority=authservice.saveAuthority(authority);
	   
	   return new ResponseEntity<>(neAuthority, HttpStatus.CREATED);
	}
}
