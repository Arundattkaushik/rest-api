package com.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.User;
import com.rest.servies.UserService;


@RestController
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/create")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	@GetMapping(path = "/user/list")
	public ResponseEntity<List<User>> getUserList(){
		List<User> userList = this.userService.getUsers();
		if (userList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		else {
			return ResponseEntity.of(Optional.of(userList));
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> getUser(@RequestParam("id") int id) {
		User user = this.userService.getAUser(id);
		if (user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(user));
		}
	}
	
	
	@PutMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam("id") int id) {
		User u = this.userService.updateUser(user, id);
		if (u==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		else {
			return ResponseEntity.of(Optional.of(u));	
		}
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
		this.userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
