package com.controller;

import java.util.List;
import java.util.Optional;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.User;

//@RestController
@RequestMapping("/user")
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") Integer id){
		return userService.getUserById(id);
	}
	
	@PostMapping
	public User postByUser(@RequestBody User user){
		return userService.postByUser(user);	
	}
	
	@PutMapping("/{id}")
	public Optional<User> updateById(@PathVariable("id") int id, @RequestBody User user  ){
		return Optional.ofNullable(userService.updateById(id, user));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id){
		userService.deleteById(id);
	}
	
	@GetMapping("/all")
	public List<User> getListOfUser(){
		return userService.getListOfUser();
	}
}