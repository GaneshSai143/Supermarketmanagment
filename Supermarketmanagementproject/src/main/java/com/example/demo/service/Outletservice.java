package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Outlet;

import com.example.demo.entity.dto.Outletdto;


public interface Outletservice {

	
	public List<Outlet> getAll();
	public Outlet create(Outletdto user) throws Exception ;
		
		public Outlet update(Outletdto user);
		
		//public int prodductquantity(Outletdto p)throws Exception;
		 public void delete(int id);
		 Outlet getOutletById(int id);
}
