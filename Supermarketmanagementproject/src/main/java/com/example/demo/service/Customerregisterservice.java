package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.Userdto;

public interface Customerregisterservice {

	public User create(Userdto user) throws Exception;
}
