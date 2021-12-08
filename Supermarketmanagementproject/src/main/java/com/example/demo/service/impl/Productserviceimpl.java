package com.example.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.Productrepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Productservice;

@Service
public class Productserviceimpl implements Productservice {
	@Autowired
	private UserRepository urepo;
	@Autowired
	private Productrepository prepo;

	@Override
	public List<Products> getAll() {

		return prepo.findAll();
	}

	@Override
	@Transactional 
	public Products create(Productdto user) {

		Products p=new Products();
		p.setPname(user.getPname());
		p.setQuantity(user.getQuantity());
		p.setPrice(user.getPrice());
		
		
		User u= this.urepo.findByUsername(user.getUsername());
		p.setUser(u);
		return prepo.save(p);
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