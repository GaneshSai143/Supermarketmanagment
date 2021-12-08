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
}
