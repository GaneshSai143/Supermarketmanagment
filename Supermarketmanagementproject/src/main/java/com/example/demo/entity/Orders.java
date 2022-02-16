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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	@NotBlank(message="p;ease provide order_name")
	//@NotEmpty(message="please provide order_name")
	private String order_name;
	@NotBlank(message="please provide order_delivered")
	//@NotEmpty(message="please provide order_delivered")
	
	private String order_delivered;
	@NotBlank(message="please provide order_canceled")
	//@NotEmpty(message="please provide order_canceled")
	private String order_canceled;
	@NotBlank(message="please provide customer address")
	//@NotEmpty(message="please provide customer address")
	@Column(name="address")
	private String customerdeliveryaddress;
	@NotBlank(message="please provide orderstatus")
	//@NotEmpty(message="please provide orderstatus")
	private String orderstatus;
//	@NotBlank
	//@NotEmpty(message="please provide order quantity")
	@NotNull(message="please provide order quantity")
	private Integer quantity;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "outlet_orders", 
		joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "outlet_id", referencedColumnName = "id"))
	@OrderBy
	
	@JsonIgnore
	@Valid
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
	//@NotNull(message="please provide valid products")
	@JsonIgnore
	@Valid
	private Collection<Products> products ;
	
}
