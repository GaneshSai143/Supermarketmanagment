package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.Orders;
import com.example.demo.entity.Outlet;
import com.example.demo.entity.dto.Orderdto;


public interface Orderservice {

	
	public List<Orders> getorders();
	public Orders bookingorder(Orderdto orders);
	
	public int productandorderquantity(int id)throws Exception;
	
	public Orders update(Orderdto user);
	
	public void delete(int id);
	Orders getOrderById(int id);
	List<Orders> getallorders();
	List<Orders> getorder();
}
