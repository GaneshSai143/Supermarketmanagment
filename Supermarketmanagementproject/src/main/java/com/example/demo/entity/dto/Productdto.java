package com.example.demo.entity.dto;



import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Productdto {
	
	private int id;
	@NotBlank(message="please provide product name")
	
	private String pname;
	@NotNull(message="please provide quantity")
	 private Integer quantity;
	@NotNull(message="please provide price")
	 private Long price; 
	@NotNull(message="please provide productcode")
	 private Integer pcode;
	 private String  username;
     private int orderquantity;
     //private List<String> outletname;
     
     
     
	
	
}
