package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.dto.Orderdto;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.service.impl.Orderserviceimpl;
import com.example.demo.service.impl.Productserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class Ordercontroller {
	
	@Autowired
	private Orderserviceimpl oservice;
	
	
	@GetMapping
	public List<Orders> getorders()
	{
		return oservice.getallorders();
	}
	
	@GetMapping(value="/{id}")
	public Orders getquantities(@Valid @PathVariable int id) throws Exception{
		 return this.oservice.getOrderById(id);
	}
	
	@PostMapping
	public ResponseEntity<Orders> create(@Valid @RequestBody Orderdto orders) throws Exception {
	
       oservice.bookingorder(orders);
        HttpHeaders headers = new HttpHeaders();
        
        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
           
	}
	
	@PutMapping(value="/{id}")
	public Orders updatethequanity(@Valid @RequestBody Orderdto orders ,@PathVariable int id) {
		orders.setId(id);
		return oservice.update(orders);
	
		}
	
	@GetMapping("/productqupdate/{id}")
	public int updateproduct(@Valid @PathVariable int id)throws Exception {
		return oservice.productandorderquantity(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteproducts(@Valid @PathVariable int id) {
		oservice.delete(id);
	}

}

