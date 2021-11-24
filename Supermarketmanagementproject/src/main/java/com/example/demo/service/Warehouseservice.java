package com.example.demo.service;

//import java.util.List;
//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class Warehouseservice {

	/*@Autowired
	private UserRepository userrepo;
	

	
	
	public User getUserInfoByUserName(String userName) {
		//short enabled = 1;
		//return userrepo.findByUserNameAndEnabled(userName, enabled);
		return userrepo.findByUsername(userName);
	}

	/*public List<User> getAllActiveUserInfo() {
		return userrepo.findAllByEnabled((short) 1);
	}

	public User getUserInfoById(int id) {
		return userrepo.findById(id);
	}

	public User addUser(User userInfo) {
		userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
		return userrepo.save(userInfo);
	}

	public User updateUser(int id, User user) {
		User userInfo = userrepo.findById(id);
		userInfo.setUsername(user.getUsername());
		userInfo.setPassword(user.getPassword());
		userInfo.setEmailid(user.getEmailid());
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		//userInfo.setEnabled(user.getEnabled());
		return userrepo.save(userInfo);
	}

	public void deleteUser(int id) {
		userrepo.deleteById(id);
	}

	public User updatePassword(int id, User userRecord) {
		User userInfo = userrepo.findById(id);
		userInfo.setPassword(userRecord.getPassword());
		return userrepo.save(userInfo);
	}

	public User updateRole(int id, User userRecord) {
		User userInfo = userrepo.findById(id);
		userInfo.setRole(userRecord.getRole());
		return userDatailsRepository.save(userInfo);
	}*/
	
}
