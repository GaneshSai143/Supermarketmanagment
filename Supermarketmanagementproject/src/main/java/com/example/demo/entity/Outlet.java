package com.example.demo.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="outlet")
@Getter
@Setter

public class Outlet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outlet_sequence")
	@SequenceGenerator(name = "outlet_sequence", sequenceName = "outlet_sequence", allocationSize = 1)
	
	private int id;
	
	//@NotNull(message="please provide outletname")
	private String outletname;
	
	//@NotNull(message="please provide code")
	@Column(name="ocode", unique = true)
	private int ocode;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Outlet_products", 
		joinColumns = @JoinColumn(name = "user_outlet_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	@OrderBy
	@NotNull(message="please valid outletname")
	@JsonIgnore
	private Collection<Products> products ;
 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User cuser;
}
