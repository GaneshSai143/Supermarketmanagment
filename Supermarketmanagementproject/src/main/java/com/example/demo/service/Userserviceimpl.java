package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class Userserviceimpl implements Userservice {

	@Autowired
	private UserRepository repository;

	
	@Override
    @Transactional(readOnly = true)
	public List<User> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void create(User user) {
	  repository.save(user);
		
	}

	@Override
	public User update(User user) {
	
		return repository.save(user);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
		
	}

}
