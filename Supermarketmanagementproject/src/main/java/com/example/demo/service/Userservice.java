package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.Outletdto;
import com.example.demo.entity.dto.Productdto;
import com.example.demo.entity.dto.Userdto;

public interface Userservice {
	
	public List<User> getAll();
//public User create(Userdto user) throws Exception;
	
	public User update(Userdto user);
	
	 public void delete(int id);
	User getUserById(int id);

	List<Outlet> getAlloutlets();

	List<Products> getAllproducts();
	
	User getUserByEmalId(String emailId);

}
