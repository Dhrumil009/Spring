package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDao {
	void save(User user);
	List<User> list();
}