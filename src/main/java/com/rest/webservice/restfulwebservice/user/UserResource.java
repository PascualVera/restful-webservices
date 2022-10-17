package com.rest.webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {
private UserDaoService userService;
	
	public UserResource(UserDaoService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping( path ="/users")
	public List<User> getAllUsers() {
		List<User> users = this.userService.findAll();
		return users;
	}
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = this.userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+ id);
		}
		return user;
		
	}
	@PostMapping(path = "/users")
	public ResponseEntity<Object> postUser(@Valid @RequestBody User user) {
		this.userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping(path = "/users/{id}")
	
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		
		if(this.userService.delete(id)) {
		return ResponseEntity.accepted().build();
		}
		throw new UserNotFoundException("id: "+ id);
	}
	
}