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

	@Query(value = "\r\n"
			+ "select p.quantity-o.quantity from orders o join order_products op on op.orders_id=o.id\r\n"
			+ "join products p on p.id=op.product_id \r\n"
			+ "where o.id=:id",
			 nativeQuery = true)
	int findByQuantity(@Param("id") int id);
	
	/*@Query(value=
			"select p.* from products p join order_products op on op.product_id=p.id \r\n"
			+ " where op.orders_id in(:id)", nativeQuery = true
			)
	Products findProducts(@Param("id") int id);*/
	
}
