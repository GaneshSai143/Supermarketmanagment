package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
	
	 @Query("SELECT DISTINCT user FROM User user " +
	            "INNER JOIN FETCH user.authorities AS authorities " +
	            "WHERE user.username = :username")
	    public User findByUsername(@Param("username") String username);

	// @Query("delete from User where id=:id")
		public void deleteById(@Param("id")int id);

		public User findByEmailId(String emailId);

		
	/*@Query(value="select * from user_info u where u.email=:emailId",nativeQuery = true)
		public User findByEmailId(@Param("emailId") String emailId);*/
		
		@Query(value="select * from user_info u join  orders o on u.id=o.user_id where u.user_name=:user",nativeQuery = true)
		List<User> findcustomer(@Param("user")String user);
		
		@Query(value="SELECT * FROM user_info ui  WHERE ui.email !=:username",nativeQuery = true)
		List<User> findwithoutsuper(@Param("username")String username);
		
		
		@Query(value="select u from user u where CONCAT(u.id,' ',u.firstName,' ',u.lastName,' ',u.emailId,' ',u.username)LIKE %:keyword%",
				nativeQuery= true)
		List<User>search(@Param("keyword")String keyword);

	
}
