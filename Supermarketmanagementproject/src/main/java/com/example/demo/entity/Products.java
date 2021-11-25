package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	
	@Id
 private int id;
 @Column(name="product_name")
 private String pname;
 private long quantity;
 private long price;
 
 @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_products", 
		joinColumns = @JoinColumn(name = "user_product_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
	@OrderBy
	@JsonIgnore
	private Collection<Orders> orders ;
}
