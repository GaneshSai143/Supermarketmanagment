package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Products;

@Repository
public interface Productrepository extends JpaRepository<Products, Integer> {

	@Query(value = "SELECT * FROM Products p where p.pcode IN (:pcode) ", nativeQuery = true)
    List<Products> find(@Param("pcode") List<Integer> pcode);
	
	@Query(value=
			"select p.* from products p join order_products op on op.product_id=p.id \r\n"
			+ " where op.orders_id in(:id)", nativeQuery = true
			)
	Products findProducts(@Param("id") int id);
	
	
	@Query(value="select p.quantity from products p join order_products op on p.id=op.product_id\r\n"
			+ "where op.orders_id= :id" , nativeQuery = true)
	int findProductQuantity(@Param("id") int id);
	
	@Query(value ="select p.* from products p join order_products op on p.id=op.product_id\r\n"
			+ "join orders c on op.orders_id=c.id join outlet_orders oc on c.id=oc.order_id\r\n"
			+ "where p.quantity <=0 and oc.outlet_id=:id"
			 ,nativeQuery = true)
	
	Products findproductsq(@Param("id") int id);
}
