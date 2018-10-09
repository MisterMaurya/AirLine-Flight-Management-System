package com.airlines.dao.api;

import java.util.List;

import com.airlines.entity.User;

public interface UserDAO {
	public boolean saveUser(User user);

	public boolean deleteUser(User user);

	public List<User> getAllUser();

	public User getUserByUserName(String userName);

	public User getUserByEmail(String email);

	public boolean updateUser(User user) throws Exception;

	public boolean validateOTP(String email,String code) throws Exception;

}
