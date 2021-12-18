package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authority;
//import com.example.demo.entity.PasswordGenerator;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mail.Email;
import com.example.demo.mail.Emailserviceimpl;
import com.example.demo.repository.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Customerregisterservice;

@Service
public class Customerserviceregisterserviceimpl implements Customerregisterservice {

	@Autowired
	private UserRepository userRepository;
	
	/*@Autowired
	private PasswordGenerator passwordGenerator;
	*/
	@Autowired
	private Emailserviceimpl emailservice;
	
	@Autowired
	private Role rrepo;
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	@Transactional
	public User create(Userdto user) throws Exception {
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
	        /*PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	        String pass=user.getPassword();
	        String encodedPassword = passwordEncoder.encode(pass);
	        System.out.println(pass);
	        user1.setPassword(encodedPassword);*/
	        String password=user.getPassword();
	        user1.setPassword(new BCryptPasswordEncoder().encode(password));
	        
	        
	        User u2=null;
	        
	        
	        List<Authority> allList=rrepo.findAll();
	        String RoleSuper=allList.get(2).getName();
	        List<String> SuperAdminList=new ArrayList<String>();
	        SuperAdminList.add(RoleSuper);
	        
	        Authority addAuthorities=rrepo.find(user.getRoletype());
	       
	        if(RoleSuper.equals(user.getRoletype()))
	        {
	        	user1.setAuthorities(List.of(addAuthorities));
	            u2= userRepository.save(user1);
	        	
	        }
	        else
	        {
	        	throw new ResourceNotFoundException("this role was not added ");
	        }
	        
	        	
	        	
	        	
	        
	  Email mail = new Email();
	  mail.setSubject("Welcome to Super market Management System Program");
	  mail.setToEmail(user1.getEmailid());
	  mail.setContent("You account was created sucessfully "+"\n" +"Username :"+user.getUsername() +"\n"+ "password :"+password);
	  emailservice.sendEmail(mail);
	  return u2;
	}

}
