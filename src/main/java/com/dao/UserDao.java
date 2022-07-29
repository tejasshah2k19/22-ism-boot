package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (firstname,lastname,email,password,gender,usertype)  values (?,?,?,?,?,?) ",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getGender(),
				user.getUserType());
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ? ", userId);
	}

	public void updateUser(UserBean user) {
		stmt.update("update users set firstname = ? , lastname = ? where userId = ? ", user.getFirstName(),
				user.getLastName(), user.getUserId());
	}

	public UserBean getUserByEmail(String email) {

		List<UserBean> users = null;
		try {
			// ram@gmail.com -->2
			users = stmt.query("select * from users where email = ? ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
		} catch (Exception e) {
			System.out.println("user not present!!!");
		}
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
