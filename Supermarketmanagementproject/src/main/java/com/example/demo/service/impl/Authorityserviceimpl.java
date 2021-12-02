package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Authority;
import com.example.demo.repository.Role;

@Service
public class Authorityserviceimpl {

	@Autowired
	private Role role;
	
	@Transactional
	public Authority saveAuthority(Authority authority) {
		
		Authority newAuthority=role.save(authority);
		return newAuthority;
	}
	
}
