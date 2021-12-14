package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;

@Repository
public interface Orderrepository extends JpaRepository<Orders, Integer> {

	@Query(value="select  u.email  from\r\n"
			+ "orders oo join user_info u on u.id=oo.user_id where oo.id= :id" ,nativeQuery = true)
	String finduserEmail(@Param("id") int id);
	
	@Query(value = "select quantity from orders where id= :id" ,nativeQuery = true)
	int findByQuantity(@Param("id") int id);
}
