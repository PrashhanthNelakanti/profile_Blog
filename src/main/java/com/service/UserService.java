package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public User postByUser(User user) {
		return userRepository.save(user);
	}

	public User updateById(Integer id, User user) {
		Optional<User> updatedUser=userRepository.findById(id);
		updatedUser.get().setLocation(user.getLocation());
		updatedUser.get().setName(user.getName());
		updatedUser.get().setSalary(user.getSalary());
		return userRepository.save(updatedUser.get());
	}

	public void deleteById(int id) {
		userRepository.delete(userRepository.findById(id).get());
	}

	public List<User> getListOfUser() {
		return userRepository.findAll();
	}
}