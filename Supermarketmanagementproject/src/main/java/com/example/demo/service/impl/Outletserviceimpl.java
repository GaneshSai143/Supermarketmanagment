package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		shops.setOcode(user.getOcode());
		
		
		Userdto users= user.getUserdto();
		
		
        User user1 = new User();
      
        user1.setFirstName(users.getFirstName());
        user1.setLastName(users.getLastName());
        user1.setUsername(users.getUsername());
        user1.setEmailid(users.getEmailId());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
        String pass=passwordGenerator.generateRandomPassword(8);
        String encodedPassword = passwordEncoder.encode(pass);
        System.out.println(pass);
        user1.setPassword(encodedPassword);
        
       
        User u=null;
        
        
        List<Authority> allList=rrepo.findAll();
        /*String RoleSuper=allList.get(0).getName();
        List<String> SuperAdminList=new ArrayList<String>();
        SuperAdminList.add(RoleSuper);
        
        List<Authority> addAuthorities=rrepo.find(users.getRoletype());*/
        
        Authority addList=rrepo.find(users.getRoletype().toUpperCase());
       for(int i=0;i<allList.size();i++)
       { 
      	 
      	if(users.getRoletype().equalsIgnoreCase(allList.get(i).getAuthority()))
      	 {
      		 System.out.println("if manin "+users.getRoletype());
      		
      		 if(users.getRoletype().equalsIgnoreCase(allList.get(0).getAuthority()))
      			{
      			
      			 System.out.println(allList.get(i).getAuthority()+"inner if");
      			 throw new ResourceNotFoundException("u cant add");
      		 }
      		 
      		 else if(allList.get(0).getAuthority()!=users.getRoletype()&&users.getRoletype().equals(allList.get(1).getAuthority())){
      			
          		 user1.setAuthorities(List.of(addList));
          		u= urepo.save(user1);
        }
        
      		 else {
      			throw new ResourceNotFoundException("u cant add");
      		 }
        
        	List<Products> products= prepo.find(user.getPcode());
        	shops.setProducts(products);
        	User u1 = urepo.findByUsername(user.getOusername());
    		shops.setCuser(u1);
    	/*	User u12= null;
    		
    		Object users1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    		if (users instanceof UserDetails) {
    		  String username = ((UserDetails)users1).getUsername();
    		  u=this.urepo.findByUsername(username);
    		  shops.setUser(u12);
    		} else {
    		  String username = users.toString();
    	}*/
        	
        	shops.setUser(u);
      	 }
       }
        
  Email mail = new Email();
  mail.setSubject("Welcome to Super market Management System Program");
  mail.setToEmail(user1.getEmailid());
  mail.setContent("You were added by "+users.getRoletype()+"\n" +"Username :"+users.getUsername() +"\n"+ "password :"+pass);
  emailservice.sendEmail(mail);

		return orepo.save(shops);
	}
       
	
       
	
	

	@Override
	@Transactional
	public Outlet update(Outletdto user) {

		Optional<Outlet> shop=orepo.findById(user.getId());
		if(shop.isPresent()) {
			Outlet o=shop.get();
			o.setOutletname(user.getOutletname());
			o.setOcode(user.getOcode());
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
	
	

	@Override
	@Transactional
	public String Emailsend(int id) throws Exception {
		
		String email= rrepo.findByName();
		System.out.println(email+"superadmin");
		String shopname=orepo.findOutletname(id);
		Products p= prepo.findproductsq(id);
		Products p1=new Products();
		p1.setId(p.getId());
		System.out.println(p.getId()+"p id");
		p1.setPname(p.getPname());
		p1.setPrice(p.getPrice());
		System.out.println(p.getPrice());
		int q=p.getQuantity();
		p1.setQuantity(q);
		System.out.println(q);
		p1.setUser(p.getUser());
		System.out.println(p.getUser()+"user");
	/*	p1.setOutlets(p.getOutlets());
		System.out.println(p.getOutlets()+"shops");*/
		
		
		
		if(q<=0)
		{
			Email mail = new Email();
			  mail.setSubject("Welcome to Super market Management System Program");
			  mail.setToEmail(email);
			  mail.setContent("products was null"+shopname+" in this shop please add the products");
			  emailservice.sendEmail(mail);
			
		}
		return email;
	}

	
}
