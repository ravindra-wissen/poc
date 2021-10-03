package com.capitalone.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capitalone.user.model.User;

@Service
public class UserService {

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		User user1 = new User(1l, "Rani");
		User user2 = new User(2l, "Raj");
		User user3 = new User(3l, "Pooja");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}

}
