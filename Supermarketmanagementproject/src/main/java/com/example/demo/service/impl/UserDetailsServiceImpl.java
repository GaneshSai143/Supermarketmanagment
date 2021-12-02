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
import com.example.demo.entity.dto.Userdto;
import com.example.demo.exception.ResourceNotFoundException;
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
	public User create(Userdto user) throws Exception{
	        User userWithDuplicateUsername = userRepository.findByUsername(user.getUsername());
	        if(userWithDuplicateUsername != null && user.getId() != userWithDuplicateUsername.getId()) {
	            log.error(String.format("Duplicate username %", user.getUsername()));
	            throw new RuntimeException("Duplicate username.");
	        }
	        User user1 = new User();
	        user1.setEmailid(user.getEmailId());
	        user1.setFirstName(user.getFirstName());
	        user1.setLastName(user.getLastName());
	        user1.setUsername(user.getUsername());
	        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	        String pass=passwordGenerator.generateRandomPassword(8);
	        String encodedPassword = passwordEncoder.encode(pass);
	        System.out.println(pass);
	        user1.setPassword(encodedPassword);
	        
	        List<Authority> addAuthorities=rrepo.find(user.getRoletype());
            user1.setAuthorities(addAuthorities);
            
            
	  Email mail = new Email();
	  mail.setSubject("Welcome to Super market Management System Program");
	  mail.setToEmail(user1.getEmailid());
	  mail.setContent("You were added by " +"Username :"+user.getUsername() +"\n"+ "password :"+pass);
	  emailservice.sendEmail(mail);
	  return userRepository.save(user1);
	  
	}
	
	
	
	
	@Override
	@Transactional
	public User update(Userdto user) {
		
Optional<User> userdb=this.userRepository.findById(user.getId());
		
		if(userdb.isPresent()) {
			User userUpdate=userdb.get();
			userUpdate.setId(user.getId());
			userUpdate.setUsername(user.getUsername());
			userUpdate.setFirstName(user.getFirstName());
			userUpdate.setLastName(user.getLastName());
			userUpdate.setEmailid(user.getEmailId());
		    userUpdate.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
		    userRepository.save(userUpdate);
		    return userUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id" + user.getId());
		}
		
	}
	@Override
	@Transactional
	public void delete(int id) {
Optional<User> userdb=this.userRepository.findById(id);
		
		if(userdb.isPresent()) {
			
			this.userRepository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Record not found with id  :" +id);
		}
	
	}
	
	@Override
	@Transactional
	public User getUserById(int id) {
		Optional<User> userdb=this.userRepository.findById(id);
		if(userdb.isPresent()) {
			return userdb.get();
		}
		
		else {
			throw  new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}
}


