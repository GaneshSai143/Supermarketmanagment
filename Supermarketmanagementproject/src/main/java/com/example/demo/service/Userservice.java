package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface Userservice {
	
	public List<User> getAll();
public void create(User user);
	
	public User update(User user);
	
	 public void delete(int id);
	 
	 public void delete(User user);
}
