package com.example.demo.entity.dto;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Outletdto {
	
	

	private int id;
	private String outletname;
	private Userdto userdto;
	 private List<String> products;
	 private int quantity;
	 private int productquantity;
	 
}
