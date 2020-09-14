package com.unay.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unay.taskmanager.model.User;
import com.unay.taskmanager.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		List<User> listUser = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			listUser.add(user);
		}
		return listUser;
	}

	public User mapToUser(Map<String, String> map) {
		User user = new User();
		user.setUsername(map.get("username"));
		user.setPassword(map.get("password"));
		return user;
	}

	public boolean checkUsername(Map<String, String> map) {
		return userRepository.findById(map.get("username")).isPresent();
	}

	public boolean save(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean login(User user) {
		return userRepository.findById(user.getUsername()).isPresent()
				&& userRepository.findById(user.getUsername()).get().getPassword().equals(user.getPassword());
	}

	public boolean updatePassword(Map<String, String> map) {
		map.put("username", map.get("oldUsername"));
		if (checkUsername(map)) {
			User user = userRepository.getOne(map.get("oldUsername"));
			if (user.getPassword().equals(map.get("oldPassword"))) {
				user.setPassword(map.get("newPassword"));
				user = userRepository.save(user);
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean createNewUser(Map<String, String> map) {
		if (!checkUsername(map)) {
			System.out.println("Saving");
			return save(mapToUser(map));
		} else {
			System.out.println("User Exists");
			return false;
		}
	}
}
