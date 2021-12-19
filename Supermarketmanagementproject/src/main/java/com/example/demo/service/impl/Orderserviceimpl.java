package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Orderdto;
import com.example.demo.entity.dto.Outletdto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mail.Email;
import com.example.demo.mail.Emailserviceimpl;
import com.example.demo.repository.Orderrepository;
import com.example.demo.repository.Outletrepository;
import com.example.demo.repository.Productrepository;
import com.example.demo.repository.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Orderservice;

@Service
public class Orderserviceimpl implements Orderservice {

	@Autowired
	private UserRepository urepo;
	@Autowired
	private Outletrepository orepo;
	@Autowired
	private Productrepository prepo;

	@Autowired
	private Emailserviceimpl emailservice;
	@Autowired
	private Orderrepository orderrepo;
	
	
	@Override
	public List<Orders> getorders() {

		return orderrepo.findAll();
	}
	
	

	@Override
	@Transactional
	public Orders bookingorder(Orderdto orders) {

		Orders o1=new Orders();
		o1.setOrder_name(orders.getOrder_name());
		o1.setOrder_delivered(orders.getOrder_delivered());
		o1.setOrder_canceled(orders.getOrder_canceled());
		o1.setCustomerdeliveryaddress(orders.getCustomerdeliveryaddress());
		o1.setOrderstatus(orders.getOrderstatus());
		
		o1.setQuantity(orders.getQuantity());
		
		
		List<Products> products= prepo.find(orders.getPcode());
		
    	o1.setProducts(products);
    	
    	
    	List<Outlet> outlets= orepo.find(orders.getOcode());
    
    	o1.setOutlets(outlets);
    	
    	User u1 = urepo.findByUsername(orders.getUsername());
		o1.setUser(u1);
 /*   	
User u= null;
		
		Object users = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (users instanceof UserDetails) {
		  String username = ((UserDetails)users).getUsername();
		  u=this.urepo.findByUsername(username);
		  o1.setUser(u);
		} else {
		  String username = users.toString();
	}*/
    	
    	
		
		return orderrepo.save(o1);
	}

	@Override
	@Transactional
	public int productandorderquantity(int id)throws Exception {
		int o= orderrepo.findByQuantity(id);
		int pq=prepo.findProductQuantity(id);
		int q=pq-o;
		
		Products p= prepo.findProducts(id);
		Products p1=new Products();
		p1.setId(p.getId());
		p1.setPname(p.getPname());
		p1.setPrice(p.getPrice());
		p1.setPcode(p.getPcode());
		p1.setQuantity(q);
		p1.setUser(p.getUser());
	//	p1.setOutlets(p.getOutlets());
		prepo.save(p1);
		
		String email=orderrepo.finduserEmail(id);
		
		Email mail = new Email();
		  mail.setSubject("Welcome to Super market Management System Program");
		  mail.setToEmail(email);
		  mail.setContent("You have ordered sucessfully with order_id : "+id);
		  emailservice.sendEmail(mail);
		
		return q;
	
	}
	
	@Override
	public Orders getOrderById(int id) {

Optional<Orders> shops=this.orderrepo.findById(id);
		
		if(shops.isPresent()) {
		
			return shops.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}
	



	@Override
	@Transactional
	public Orders update(Orderdto user) {
		
	Optional<Orders> o= orderrepo.findById(user.getId());
	if(o.isPresent()) {
		Orders o1=o.get();
		o1.setOrder_name(user.getOrder_name());
		System.out.println(user.getOrder_name()+"oname");
		o1.setOrder_delivered(user.getOrder_delivered());
		o1.setOrder_canceled(user.getOrder_canceled());
		o1.setCustomerdeliveryaddress(user.getCustomerdeliveryaddress());
		o1.setOrderstatus(user.getOrderstatus());
		o1.setQuantity(user.getQuantity());
		System.out.println(user.getQuantity());

		  
		 orderrepo.save(o1);
		 
		 return o1;
		
	}
	else
	{
		throw new ResourceNotFoundException("the order id was not found");
	}
	}



	@Override
	@Transactional
	public void delete(int id) {
		Optional<Orders> odelete=this.orderrepo.findById(id);
		if(odelete.isPresent()) {
			this.orderrepo.deleteById(id);
			
		}
		
		else {
			throw  new ResourceNotFoundException("Record not found with id  :" +id);
		}
		
	}
	
	
}

	