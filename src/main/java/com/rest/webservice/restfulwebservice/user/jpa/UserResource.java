package com.rest.webservice.restfulwebservice.user.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restfulwebservice.user.User;
import com.rest.webservice.restfulwebservice.user.UserDaoService;
import com.rest.webservice.restfulwebservice.user.UserNotFoundException;


@RestController
public class UserResource {
	
private UserRepository repository;
private UserDaoService userService;
	
	public UserResource(UserDaoService userService, UserRepository repository) {
		super();
		this.userService = userService;
		this.repository = repository;
	}
	
	@GetMapping( path ="/users")
	public List<User> getAllUsers() {
		return repository.findAll();
		
	}
	@GetMapping(path = "/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id: "+ id);
		}
		return user;
		
	}
	@PostMapping(path = "/users")
	public ResponseEntity<Object> postUser(@Valid @RequestBody User user) {
		repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/users/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		User target = this.userService.update(user);
		if(target == null) {
			throw new UserNotFoundException("id: "+ id);
		}
		return target;
	}
	
	@DeleteMapping(path = "/users/{id}")
	
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
}