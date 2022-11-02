package com.UST.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.api.dto.UserRequest;
import com.UST.api.model.User;
import com.UST.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public User saveUser(@Valid UserRequest userrequest) {
		User user=new User();
		user.setName(userrequest.getName());
		user.setEmail(userrequest.getEmail());
		user.setGender(userrequest.getGender());
		user.setMobile(userrequest.getMobile());
		user.setAge(userrequest.getAge());
		user.setNationality(userrequest.getNationality());
		
		return repository.save(user);
	}

	public List<User> getAllUsers() {
		
		return repository.findAll();
	}

}
