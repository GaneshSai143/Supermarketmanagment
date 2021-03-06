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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
	
 private int id;
 @Column(name="product_name")

@NotBlank(message="please provide productname")
 private String pname;
 @NotNull(message="please provide quantity")

 private Integer quantity;
@NotNull(message="please provide price")

 private Long price;
@NotNull(message="please provide productcode")

 @Column(name="pcode", unique = true)
 private Integer pcode;
 
private boolean isselected =false;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn
 @JsonIgnore
 private User user;
}
