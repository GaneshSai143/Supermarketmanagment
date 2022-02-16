package com.example.demo.entity.dto;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	@NotBlank(message="please provide outletname")
	private String outletname;
	@NotNull(message="please provide outletcode")
	private Integer ocode;
	@Valid
	private Userdto userdto;
	 private List<Integer> pcode;
	 private int quantity;
	 private String ousername;
	 
	 
}
