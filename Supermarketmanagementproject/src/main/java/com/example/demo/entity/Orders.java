package com.example.demo.entity;

import java.util.Collection;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
	@SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
	
	private int id;
	@NotNull(message="please provide order_name")
	private String order_name;
	@NotNull(message="please provide order_delivered")
	private String order_delivered;
	@NotNull(message="please provide order_canceled")
	private String order_canceled;
	@NotNull(message="please provide customer address")
	@Column(name="address")
	private String customerdeliveryaddress;
	@NotNull(message="please provide orderstatus")
	private String orderstatus;
	@NotNull(message="please provide order quantity")
	private int quantity;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "outlet_orders", 
		joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "outlet_id", referencedColumnName = "id"))
	@OrderBy
	@NotNull(message="please provide valid outletname")
	@JsonIgnore
	private Collection<Outlet> outlets ;
 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_products", 
		joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	@OrderBy
	@NotNull(message="please provide valid products")
	@JsonIgnore
	private Collection<Products> products ;
	
}
