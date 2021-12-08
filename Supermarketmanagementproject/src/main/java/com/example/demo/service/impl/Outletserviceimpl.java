package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authority;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.PasswordGenerator;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Outletdto;
import com.example.demo.entity.dto.Userdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mail.Email;
import com.example.demo.mail.Emailserviceimpl;
import com.example.demo.repository.Outletrepository;
import com.example.demo.repository.Productrepository;
import com.example.demo.repository.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Outletservice;


@Service
public class Outletserviceimpl implements Outletservice{
	
	
	
	@Autowired
	private UserRepository urepo;
	@Autowired
	private Outletrepository orepo;
	@Autowired
	private Productrepository prepo;
	
	@Autowired
	private Role rrepo;
	
	@Autowired
	private PasswordGenerator passwordGenerator;
	
	@Autowired
	private Emailserviceimpl emailservice;

	@Override
	public List<Outlet> getAll() {

		
		return orepo.findAll();
	}

	@Override
	public Outlet create(Outletdto user) throws Exception  {
		
		Outlet shops=new Outlet();
		shops.setOutletname(user.getOutletname());
		
		
		
		Userdto users= user.getUserdto();
		
		
        User user1 = new User();
        user1.setEmailid(users.getEmailId());
        user1.setFirstName(users.getFirstName());
        user1.setLastName(users.getLastName());
        user1.setUsername(users.getUsername());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
        String pass=passwordGenerator.generateRandomPassword(8);
        String encodedPassword = passwordEncoder.encode(pass);
        System.out.println(pass);
        user1.setPassword(encodedPassword);
        
       
        User u=null;
        
        
        List<Authority> allList=rrepo.findAll();
        String RoleSuper=allList.get(0).getName();
        List<String> SuperAdminList=new ArrayList<String>();
        SuperAdminList.add(RoleSuper);
        
        List<Authority> addAuthorities=rrepo.find(users.getRoletype());
       
        if(SuperAdminList.equals(users.getRoletype()))
        {
        	throw new ResourceNotFoundException("this role was not added ");
        }
        else
        {
        user1.setAuthorities(addAuthorities);
        
        }
        u= urepo.save(user1);
     
        
        	List<Products> products= prepo.find(user.getProducts());
        	shops.setProducts(products);
        	
        	
        	shops.setUser(u);
        	
        
  Email mail = new Email();
  mail.setSubject("Welcome to Super market Management System Program");
  mail.setToEmail(user1.getEmailid());
  mail.setContent("You were added by "+RoleSuper+"\n" +"Username :"+users.getUsername() +"\n"+ "password :"+pass);
  emailservice.sendEmail(mail);

		return orepo.save(shops);
	}

	@Override
	@Transactional
	public Outlet update(Outletdto user) {

		Optional<Outlet> shop=this.orepo.findById(user.getId());
		if(shop.isPresent()) {
			Outlet o=shop.get();
			o.setOutletname(user.getOutletname());
			
			orepo.save(o);
			return o;
		}
		else {
			throw new ResourceNotFoundException("the id was not found in the shops");
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
Optional<Outlet> shops=this.orepo.findById(id);
		
		if(shops.isPresent()) {
			
			this.orepo.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}

	@Override
	public Outlet getOutletById(int id) {

Optional<Outlet> shops=this.orepo.findById(id);
		
		if(shops.isPresent()) {
			
			return shops.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}

}
