package com.example.demo.service.impl;

import java.util.*;
import java.util.stream.Collectors;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.demo.entity.*;
import com.example.demo.mail.Email;
import com.example.demo.mail.Emailserviceimpl;

import com.example.demo.repository.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Userservice;


@Service
public class UserDetailsServiceImpl implements UserDetailsService ,Userservice{

	  private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private Emailserviceimpl emailservice;
	
	@Autowired
	private Role rrepo;
	
	@Autowired
	private PasswordGenerator passwordGenerator;
	

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
	@Override
	 public List<User> getAll() {
		 return userRepository.findAll();
	 }
	@Override
	@Transactional
	public void create(User user) throws Exception{
	        User userWithDuplicateUsername = userRepository.findByUsername(user.getUsername());
	        if(userWithDuplicateUsername != null && user.getId() != userWithDuplicateUsername.getId()) {
	            log.error(String.format("Duplicate username %", user.getUsername()));
	            throw new RuntimeException("Duplicate username.");
	        }
	        User user1 = new User();
	        user1.setEmailid(user.getEmailid());
	        user1.setFirstName(user.getFirstName());
	        user1.setLastName(user.getLastName());
	        user1.setUsername(user.getUsername());
	        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	        String pass=passwordGenerator.generateRandomPassword(8);
	        String encodedPassword = passwordEncoder.encode(pass);
	        System.out.println(pass);
	        user.setPassword(encodedPassword);
	 
	  userRepository.save(user);
	  
	  Email mail = new Email();
	  mail.setSubject("Welcome to Super market Management System Program");
	  mail.setToEmail(user.getEmailid());
	  mail.setContent("You were added by " +"Username :"+user.getUsername() +"\n"+ "password :"+pass);
	  emailservice.sendEmail(mail);
	 
	}
	
	
	
	
	@Override
	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}
	@Override
	@Transactional
	public void delete(int id) {
	 userRepository.deleteById(id);
	}
	
	}


