package com.example.demo.controller;

import java.net.http.HttpHeaders;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.Warehouseservice;

@RestController
public class Warehousecontroller {
	@Autowired
	private Warehouseservice wsservice;
	@GetMapping("/d")
	public String demo()
	{
		return "hi ganesh";
	}
	/*@GetMapping("/user")
	public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
		User userInfos = wsservice.getUserInfoByUserName(null);
		if (userInfos == null || userInfos.isEnabled()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return userInfos;
	}
	
	

	@PostMapping("/user")
	public User addUser(@RequestBody User userRecord) {
		return wsservice.addUser(userRecord);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User userRecord, @PathVariable int id) {
		return wsservice.updateUser(id,userRecord);
	}
	
	@PutMapping("/user/changePassword/{id}")
	public User updateUserPassword(@RequestBody User userRecord, @PathVariable int id) {
		return wsservice.updatePassword(id,userRecord);
	}
	
	/*@PutMapping("/user/changeRole/{id}")
	public User updateUserRole(@RequestBody User userRecord, @PathVariable int id) {
		return wsservice.updateRole(id,userRecord);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		wsservice.deleteUser(id);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User userInfo = wsservice.getUserInfoById(id);
		if (userInfo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}*/
}
