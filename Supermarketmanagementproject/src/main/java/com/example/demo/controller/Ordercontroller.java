package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.entity.dto.Orderdto;
import com.example.demo.service.impl.Orderserviceimpl;

@RestController
public class Ordercontroller {
	
	@Autowired
	private Orderserviceimpl oservice;
	
	/*@GetMapping(value="/outlet/{id}")
	public ResponseEntity<Orders> getUserById(@PathVariable int id) {
		return ResponseEntity.ok().body(this.oservice.getOutletById(id));
	}*/
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> create(@Valid @RequestBody Orderdto orders) throws Exception {
       oservice.bookingorder(orders);
        HttpHeaders headers = new HttpHeaders();
        
        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
           
	}

}
