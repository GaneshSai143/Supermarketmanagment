package com.example.demo.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="outlets")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Outlet {

	@Id
	private int id;
	
	private String outletname;
	
	
	
}
