package com.example.demo.entity.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Productdto {
	
	private int id;
	private String pname;
	 private int quantity;
	 private long price; 
	 private String  username;
     private int orderquantity;
     private List<String> outletname;
     
     
     
	
	
}
