package com.rest.webservice.restfulwebservice.helloworld;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorld {
	
	
	@GetMapping( path ="/hello-bean")
	public List<HelloWorldBean> getHelloBean() {
		return Arrays.asList(new HelloWorldBean( "pinga"),
							 new HelloWorldBean( "pinga2"));
	}
	@GetMapping(path = "hello/{name}")
	public HelloWorldBean getCustomHello(@PathVariable String name) {
		return new HelloWorldBean(String.format("Bienvenido al club pingoso %s", name));
	}
}
