package com.example.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.Outletrepository;
import com.example.demo.repository.Productrepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Productservice;

@Service
public class Productserviceimpl implements Productservice {
	@Autowired
	private UserRepository urepo;
	@Autowired
	private Productrepository prepo;
	
	@Autowired
	private Outletrepository orepo;

	@Override
	public List<Products> getAll() {

		return prepo.findAll();
	}

	
	@Override
	public List<Products> getproducts() {

		
		Outlet u1=null;
		Object users1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	       List<Products> user=null;
			if (users1 instanceof UserDetails) {
			  String username = ((UserDetails)users1).getUsername();
			 // u1=this.urepo.findByUsername(username);
			  u1=orepo.findByoutletname(username);
			  user=prepo.findByproducts(u1.getId());
			 
			  
			} else {
			  String username = users1.toString();
		}
			return user;
	}
	
	@Override
	@Transactional 
	public Products create(Productdto user) {

		
		Products productWithDuplicatecode = prepo.findByPcode(user.getPcode());
	   	 if(productWithDuplicatecode!=null && user.getId()!=productWithDuplicatecode.getId()) {
				 throw new ResourceNotFoundException("Duplicate product code :"+  user.getPcode());
			}

			Products p=new Products();
		
				p.setPname(user.getPname());
				p.setQuantity(user.getQuantity());
				p.setPrice(user.getPrice());
				p.setPcode(user.getPcode());
			p.setIsselected(false);
			User u= null;
			
			Object users = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (users instanceof UserDetails) {
			  String username = ((UserDetails)users).getUsername();
			  u=this.urepo.findByUsername(username);
			  p.setUser(u);
			} else {
			  String username = users.toString();
}

			return prepo.save(p);
		
		//return p1;
	}
	

	@Override
	@Transactional
	public Products update(Productdto user) {

		Optional<Products> items=this.prepo.findById(user.getId());
		if(items.isPresent()) {
			Products p=items.get();
			p.setPname(user.getPname());
			p.setPrice(user.getPrice());
			p.setQuantity(user.getQuantity());
			p.setPcode(user.getPcode());
			p.setIsselected(false);
			
			prepo.save(p);
			return p;
		}
		else {
			throw new ResourceNotFoundException("the id was not found in the shops");
		}
		
	}

	@Override
	public void delete(int id) {

		Optional<Products> pdelete=this.prepo.findById(id);
		if(pdelete.isPresent()) {
			this.prepo.deleteById(id);
			
		}
		
		else {
			throw  new ResourceNotFoundException("Record not found with id  :" +id);
		}

	}

	@Override
	public Products getProductById(int id) {
		Optional<Products> p1=this.prepo.findById(id);
		if(p1.isPresent()) {
			return p1.get();
		}
		
		else {
			throw  new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}

}
