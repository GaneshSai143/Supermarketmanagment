package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="outlet")
@Getter
@Setter

public class Outlet {

	@Id
	private int id;
	
	private String outletname;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Outlet_products", 
		joinColumns = @JoinColumn(name = "user_outlet_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	@OrderBy
	@JsonIgnore
	private Collection<Products> products ;
 
}
