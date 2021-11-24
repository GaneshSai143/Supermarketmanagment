package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.Warehouseservice;

public class Warehousecontroller {
	@Autowired
	private Warehouseservice wsservice;
	
	@GetMapping("/")
	public Iterable<User> getusers(){
		return this.wsservice.listAll();
		}
	
	@PostMapping("/save")
	private int saveStudent(@RequestBody User users) {
		wsservice.saveorupdate(users);
		return users.getId();
	}
	
	@RequestMapping("/user/{id}")
	private User getStudent(@PathVariable (name="id") int id) {
		
		return wsservice.getStudentId(id);
	}
	
	@PutMapping("/edit/{sid}")
private User update(@RequestBody User users,@PathVariable int id) {
		users.setId(id);
		wsservice.saveorupdate(users);
		return users;
	}
	
	@DeleteMapping("delete/{id}")
	private void deletestudent(@PathVariable ("id") int sId) {
		wsservice.delete(sId);
	}
}
