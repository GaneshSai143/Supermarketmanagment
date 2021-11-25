package com.example.demo.service;

import java.util.List;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.*;
import com.example.demo.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user != null) {
			return user;
		}

		throw new UsernameNotFoundException(username);
			
		}
	@Transactional(readOnly = true)
	 public List<User> getAll() {
		 return userRepository.findAll();
	 }
	
	@Transactional
	public void create(User user) {

		userRepository.save(user);
	}
	
	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public void delete(int id) {
	 userRepository.delete(id);
	}
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
	}


