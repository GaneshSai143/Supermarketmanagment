package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;

public interface Orderrepository extends JpaRepository<Orders, Integer> {

	@Query(value = "SELECT * FROM ORDERS o where o.quantity IN (:orderquantity) ", nativeQuery = true)
   Orders findQuantity(@Param("orderquantity") Integer orderquantity);
	
}
