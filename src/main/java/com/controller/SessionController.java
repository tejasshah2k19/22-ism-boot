package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

import ch.qos.logback.core.status.Status;

@RestController
public class SessionController {

	@Autowired
	UserDao userDao;

	// REST client - app -- postman
	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(@RequestBody UserBean user) {
		user.setUserType("customer");

		// validation

		// duplicate email
		UserBean dbUser = userDao.getUserByEmail(user.getEmail());

		if (dbUser == null) {
			userDao.addUser(user);
			return ResponseEntity.ok(user);
		} else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(user);// back
			res.setMsg("Email Already Exists");// errmsg
			res.setCode(-1);

//			return ResponseEntity.status(HttpStatus.OK).body(user);
//            return ResponseEntity.status(HttpStatus.OK).build();
			return ResponseEntity.badRequest().body(user);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//            return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
		}
	}

	// get all users

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

	// http://localhost:9595/user/1
	// ? -> query string
	/// -> url /

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		userDao.deleteUser(userId);
		return ResponseEntity.ok("user deleted");
	}

	/// user/1/ju/ku
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(UserBean user) {
		// userId?
		// fn?
		// ln?

		userDao.updateUser(user);
		return ResponseEntity.ok(user);
	}

}
