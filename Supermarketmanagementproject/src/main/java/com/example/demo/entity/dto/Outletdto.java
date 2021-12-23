package com.example.demo.entity.dto;

import java.util.*;

import javax.validation.constraints.NotNull;

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
	@NotNull(message="please provide outletname")
	private String outletname;
	@NotNull(message="please provide outletname")
	private int ocode;
	@NotNull
	private Userdto userdto;
	@NotNull
	 private List<Integer> pcode;
	@NotNull
	 private int quantity;
	 private String ousername;
	 
	 
}
