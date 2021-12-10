package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		
		o1.setQuantity(orders.getQuantity());
		
		
		List<Products> products= prepo.find(orders.getProductname());
		
    	o1.setProducts(products);
    	
    	
    	List<Outlet> outlets= orepo.find(orders.getOutletname());
    
    	o1.setOutlets(outlets);
    	
User u= null;
		
		Object users = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (users instanceof UserDetails) {
		  String username = ((UserDetails)users).getUsername();
		  u=this.urepo.findByUsername(username);
		  o1.setUser(u);
		} else {
		  String username = users.toString();
	}
    	
    	
		
		return orderrepo.save(o1);
	}

	@Override
	@Transactional
	public void productandorderquantity(Orderdto orders) {
		/*Outlet o=this.orepo.findorderquantity(outletnames);
		System.out.println(o);*/
		int prodductquantity=orders.getProductquantity();
		int quantity=orders.getQuantity();
		Products p = prepo.findQuantity(prodductquantity);
		int q=prodductquantity-quantity;
		Products p1=new Products();
		
		p1.setQuantity(q);
		
		
		
		List<Outlet> shops=orepo.findorderquantity(orders.getOutletnames());
		List<Products>product=new ArrayList<Products>();
		product.add(p1);
		
		
		Orders cart= new Orders();
		cart.setProducts(product);
		cart.setOutlets(shops);	
	}

}
