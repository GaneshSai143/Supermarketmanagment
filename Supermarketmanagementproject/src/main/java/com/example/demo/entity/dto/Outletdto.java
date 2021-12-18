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
	private int ocode;
	private Userdto userdto;
	 private List<Integer> pcode;
	 private int quantity;
	 private String ousername;
	 
	 
}
