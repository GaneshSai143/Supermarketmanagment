package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Outlet;
import com.example.demo.entity.Products;

@Repository
public interface Outletrepository extends JpaRepository<Outlet, Integer> {

	@Query(value = "SELECT * FROM Outlet o where o.outletname IN (:outletname) ", nativeQuery = true)
    List<Outlet> find(@Param("outletname") List<String> outletname);
	
	@Query(value = "select * from outlet o inner join outlet_orders oo on o.id=oo.outlet_id \r\n"
			+ "inner join orders o1 on oo.order_id=o1.id where o.outletname=:outletnames", nativeQuery = true)
    List<Outlet> findorderquantity(@Param("outletnames") List<String> outletnames);
	
	@Query(value= "select u.email from outlet o join user_info u on o.user_id=u.id where o.id= :id" ,nativeQuery = true)
	String finduserEmail(@Param("id") int id);
	
	@Query(value ="select outletname from outlet where id=:id" ,nativeQuery = true)
	String findOutletname(@Param("id") int id);
}
