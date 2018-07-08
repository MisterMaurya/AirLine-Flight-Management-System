package com.airlines.dao.api;

import java.util.List;

import com.airlines.entity.User;

public interface UserDAO {
	public User saveUser(User user);

	public boolean deleteUser(User user);

	public List<User> getAllUser();

	public User getUserByUserName(String userName);

	public User getUserByEmail(String email);

}
