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
public class Orderdto {
	

	private int id;
	private String order_name;
	private String order_delivered;
	private String order_canceled;
	private String customerdeliveryaddress;
	private String orderstatus;
	private List<String> productname;
	private int quantity;
	private List<String> outletname;
	
	private List<String> outletnames;
	private int productquantity;
	private String username;
	

}
