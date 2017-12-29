package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {
	void save(User user);
	List<User> list();
}