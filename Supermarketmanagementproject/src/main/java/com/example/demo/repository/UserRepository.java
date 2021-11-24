package com.example.demo.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT DISTINCT user FROM User user " +
	            "INNER JOIN FETCH user.authorities AS authorities " +
	            "WHERE user.username = :username")
	    public User findByUsername(@Param("username") String username);

	 //public User findByUserNameAndEnabled(String userName, short enabled);

	//	public List<User> findAllByEnabled(short enabled);

		public User findById(int id);
	//
//		@Override
//		public UserInfo save(UserInfo userInfo);

		public void deleteById(int id);

	
}
