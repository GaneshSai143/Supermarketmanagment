package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class Warehouseservice {

	@Autowired
	private UserRepository userrepo;
	public Iterable<User>listAll(){
		return this.userrepo.findAll();
		}


	//saving the details..........
	public void saveorupdate(User user ) {
		userrepo.save(user);	
	}

	//reading the details....
	public User getStudentId(int id) {
		return userrepo.findById(id);
	}

	// Updating Details.....
	public void update(User users,int id) {
	userrepo.save(users);
	}

	//Deleting Details........
	public void delete(int id) {
		userrepo.deleteById(id);
	}
	
}
