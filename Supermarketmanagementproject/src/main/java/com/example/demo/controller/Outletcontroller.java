package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Outletdto;

import com.example.demo.service.impl.Outletserviceimpl;

@RestController
@RequestMapping("/outlets")
public class Outletcontroller {
	
	@Autowired
	private Outletserviceimpl outletservice;
	
	@GetMapping(value="/outlets")
    public List<Outlet> getAll() {
        return outletservice.getAll();
    }
	
	
	@GetMapping(value="/outlet/{id}")
	public ResponseEntity<Outlet> getUserById(@Valid @PathVariable int id) {
		return ResponseEntity.ok().body(this.outletservice.getOutletById(id));
	}
	
	@PostMapping("/outlets")
	public ResponseEntity<Outlet> create(@Valid @RequestBody Outletdto user) throws Exception {
       outletservice.create(user);
        HttpHeaders headers = new HttpHeaders();
        
        return new ResponseEntity<>(headers, HttpStatus.FOUND).ok().build();
           
	}
	
	@PutMapping(value="/outlet/{id}")
	public ResponseEntity<Outlet> update(@Valid @RequestBody Outletdto user,@PathVariable int id) {
		user.setId(id);
		return ResponseEntity.ok().body(this.outletservice.update(user));
		
		}
	
	@DeleteMapping(value="outlet/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public HttpStatus delete(@Valid @PathVariable int id) {
			System.out.println("delete sucessfully");
			this.outletservice.delete(id);
			return HttpStatus.OK;
	        
	    }
	
	@GetMapping("/sendemail/{id}")
	public String updateproduct(@Valid @PathVariable int id)throws Exception {
		return outletservice.Emailsend(id);
	}

}
