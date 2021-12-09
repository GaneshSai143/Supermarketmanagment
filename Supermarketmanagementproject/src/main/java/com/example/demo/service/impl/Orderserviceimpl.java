package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Orderdto;
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
	private Orderrepository orderrepo;
	
	
	@Override
	public List<Orders> getorders(int id) {

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
		
		Orders q=orderrepo.findQuantity(orders.getQuantity());
		int quantity=q.getQuantity();
		o1.setQuantity(quantity);
		
		
		List<Products> products= prepo.find(orders.getProductname());
		
    	o1.setProducts(products);
    	
    	
    	List<Outlet> outlets= orepo.find(orders.getOutletname());
    
    	o1.setOutlets(outlets);
    	
    	User u1= urepo.findByUsername(orders.getUsername());
    	o1.setUser(u1);
    	
		
		return orderrepo.save(o1);
	}

}
