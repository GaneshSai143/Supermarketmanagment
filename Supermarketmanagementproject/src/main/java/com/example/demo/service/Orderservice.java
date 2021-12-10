package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Orders;
import com.example.demo.entity.dto.Orderdto;

public interface Orderservice {

	
	public List<Orders> getorders(int id);
	public Orders bookingorder(Orderdto orders);
	
	public void productandorderquantity(Orderdto orders);
}
