package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.service.impl.Orderserviceimpl;
import com.example.demo.service.impl.Outletserviceimpl;
import com.example.demo.service.impl.Productserviceimpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/shops")
public class outletc {
	
	@Autowired
	private Productserviceimpl pservice;
	@Autowired
	private Orderserviceimpl oservice;
	
	@Autowired
	private Outletserviceimpl oserv;
	
	@GetMapping("/get")
	public List<Orders> getorders()
	{
		return oservice.getorder();
	}
	
//	@GetMapping
//    public List<Orders> getAll() {
//        return oservice.getorders();
//    }
	
	@GetMapping
	public List<Outlet> getoutlets()
	{
		Outlet o=oserv.getoutletname();
		List<Outlet> o1=new ArrayList<Outlet>();
		o1.add(o);
		return o1;
	}
	
	@GetMapping("/getproduct")
	public List<Products> getproducts()
	{
		return pservice.getproducts();
	}
	
	@GetMapping("/productqupdate/{id}")
	public int updateproduct(@Valid @PathVariable int id)throws Exception {
		return oservice.productandorderquantity(id);
	}

}
