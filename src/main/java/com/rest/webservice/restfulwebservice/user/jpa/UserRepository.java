package com.rest.webservice.restfulwebservice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restfulwebservice.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
