package com.example.demo.entity.dto;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
public class Orderdto {
	
 
	private int id;
	//@NotBlank(message="please provide order name")
	private String order_name;
	//@NotBlank(message="please provide delivery status")
	private String order_delivered;
	//@NotBlank(message="please provide cancellation status")
	private String order_canceled;
	//@NotBlank(message="please provide delivery addresss")
	private String customerdeliveryaddress;
	//@NotBlank(message="please provide status")
	private String orderstatus;
	@Valid
	private List<Integer> pcode;
	//@NotEmpty(message="please provide quantity")
	private Integer quantity;
	@Valid
	private List<Integer> ocode;
	
	//private List<String> outletnames;
	private int productquantity;
	private String username;
	

}
