package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Products;

@Repository
public interface Productrepository extends JpaRepository<Products, Integer> {

	@Query(value = "SELECT * FROM Products p where p.product_name IN (:products) ", nativeQuery = true)
    List<Products> find(@Param("products") List<String> products);
	
	@Query(value=
			"select p.* from products p join order_products op on op.product_id=p.id \r\n"
			+ " where op.orders_id in(:id)", nativeQuery = true
			)
	Products findProducts(@Param("id") int id);
	
	
}
