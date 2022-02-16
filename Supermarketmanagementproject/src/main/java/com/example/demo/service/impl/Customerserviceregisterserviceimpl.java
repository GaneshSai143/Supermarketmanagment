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
import com.example.demo.entity.dto.User1;
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
	public User create(User1 user) {
		 
/*User userWithDuplicateUsername = userRepository.findByUsername(user.getUsername());
if(userWithDuplicateUsername != null && user.getId() != userWithDuplicateUsername.getId()) {
   throw new ResourceNotFoundException("user name is already exists:"+user.getUsername());
}*/
User userWithDuplicateEmail = userRepository.findByEmailId(user.getEmailId());
if(userWithDuplicateEmail != null && user.getId() != userWithDuplicateEmail.getId()) {
   throw new ResourceNotFoundException("user email is already exists:"+user.getEmailId());
}

	User user1 = new User();
	user1.setEmailId(user.getEmailId());

	user1.setFirstName(user.getFirstName());
	user1.setLastName(user.getLastName());
	user1.setUsername(user.getEmailId());
	String password=user.getPassword();
	user1.setPassword(new BCryptPasswordEncoder().encode(password));

	User u2=null;

	List<Authority> allList=rrepo.findAll();
	String RoleSuper=allList.get(2).getName().toUpperCase();
	List<String> SuperAdminList=new ArrayList<String>();
	SuperAdminList.add(RoleSuper);
	
	Authority addAuthorities=rrepo.find(user.getRoletype().toUpperCase());

	if(RoleSuper.equals(user.getRoletype().toUpperCase()))
	{
		user1.setAuthorities(List.of(addAuthorities));
	    u2= userRepository.save(user1);
		
	}
	else
	{
		throw new ResourceNotFoundException("this role was not added "+user.getRoletype().toUpperCase());
	}

Email mail = new Email();
mail.setSubject("Welcome to Super market Management System Program");
mail.setToEmail(user1.getEmailId());
mail.setContent("You account was created sucessfully "+"\n" +"Username :"+user.getEmailId()+"\n"+ "password :"+password);
try {
emailservice.sendEmail(mail);
} catch (Exception e) {
//TODO Auto-generated catch block
e.printStackTrace();
}
return u2;
  
  
	}
}
