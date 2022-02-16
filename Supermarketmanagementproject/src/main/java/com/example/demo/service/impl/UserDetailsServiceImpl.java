 package com.example.demo.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.example.demo.entity.*;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mail.Emailserviceimpl;
import com.example.demo.repository.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Userservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
@Service
public class UserDetailsServiceImpl implements UserDetailsService ,Userservice{

	  
	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private PasswordGenerator passwordGenerator;
	
	@Autowired
	private Emailserviceimpl emailservice;*/
	
	@Autowired
	private Role rrepo;
	
	
	
	

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
		
	
		Object users1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	       List<User> username=null;
			if (users1 instanceof UserDetails) {
			  String username1 = ((UserDetails)users1).getUsername();
			 // u1=this.urepo.findByUsername(username);
			  username=userRepository.findwithoutsuper(username1);
			  //user=prepo.findByproducts(u1.getId());
			 
			  
			} else {
			  String username1 = users1.toString();
		}
			return username;
		 
	 }
	
	public List<User> searchuser(String keyword)
	{
		if(keyword != null)
		{
			userRepository.search(keyword);
		}
		return userRepository.findAll();
	}
	
	public List<User> findProductsWithSorting(String field){
        return  userRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

	public Page<User> findProductsWithPagination(int offset,int pageSize){
        Page<User> products = userRepository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<User> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<User> products = userRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
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
			userUpdate.setEmailId(user.getEmailId());
		  //  userUpdate.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
			if(user.getPassword()==null)
			{
				
				
				userUpdate.setPassword(userdb.get().getPassword());
			}
			else {
				
			
				userUpdate.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));
			}
		   // userUpdate.setAuthorities(user.ge);
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

	@Override
	public List<Outlet> getAlloutlets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> getAllproducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmalId(String emailId) {
	
		return userRepository.findByEmailId(emailId);
	}
	
}


