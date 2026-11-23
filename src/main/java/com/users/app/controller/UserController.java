package com.users.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.app.model.response.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping()
	public String getUsers()
	{
		return "get users was called";
	}
	
	@GetMapping(path = "/{userId}",
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<User> getUser(@PathVariable String userId)
	{
		User userTest= new User();
		userTest.setEmail("pocho@gmail.com");
		userTest.setFirstName("Pocho");
		userTest.setLastName("Mugrocho");
		userTest.setUserId("skasna");
		return new ResponseEntity<User>(userTest, HttpStatus.OK);
	}
	
	@PostMapping(consumes= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userTest= new User();
		userTest.setEmail(user.getEmail());
		userTest.setFirstName(user.getFirstName());
		userTest.setLastName(user.getLastName());
		userTest.setUserId(user.getUserId());
		return new ResponseEntity<User>(userTest, HttpStatus.OK);
	}
	
	@PutMapping()
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping()
	public String deleteUser() {
		return "delete user was called";
	}
}
