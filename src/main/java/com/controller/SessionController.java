package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class SessionController {

	@Autowired
	UserDao userDao;

	// REST client - app -- postman
	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(UserBean user) {
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());

		userDao.addUser(user);

		return ResponseEntity.ok(user);
	}

	// get all users

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

}
