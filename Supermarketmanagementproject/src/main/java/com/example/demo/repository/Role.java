package com.example.demo.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Authority;

@Repository
public interface Role extends JpaRepository<Authority, Long> {
	@Query(value = "SELECT * FROM Authority u where u.name IN (:authorities) ", nativeQuery = true)
    List<Authority> find(@Param("authorities") String authorities);
	
	@Query(value ="select ui.email from user_info ui join user_authority ua on ui.id=ua.user_id\r\n"
			+ "join authority a on a.id=ua.authority_id where a.name='ROLE_SUPER_ADMIN' ", nativeQuery = true)
	String findByName();
}
