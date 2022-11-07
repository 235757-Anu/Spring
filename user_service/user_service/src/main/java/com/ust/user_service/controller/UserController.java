package com.ust.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.user_service.entity.User;
import com.ust.user_service.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userid}")
	public User getUser(@PathVariable("userid") Long userid)
	{
		User user=this.userService.getUser(userid);
		//List contacts=this.restTemplate.getForObject
		return user;
	}

}
