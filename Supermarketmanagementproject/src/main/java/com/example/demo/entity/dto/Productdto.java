package com.example.demo.entity.dto;



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
	 private long quantity;
	 private long price; 
	 private String  username;

	
	
}
