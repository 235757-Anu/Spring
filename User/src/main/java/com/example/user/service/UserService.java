package com.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	 private UserRepo repository;
	
	public List<User> saveDetails(List<User> user) {
		return repository.saveAll(user);
	}

	public List<User> getDetails() {
		return repository.findAll();
	}

	public String deleteDetail(int id) {
        repository.deleteById(id);
        return id + " is removed !! " ;
	}

	public User updateDetails(User user) {
		User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setPhno(user.getPhno());
        existingUser.setAddr(user.getAddr());
        return repository.save(existingUser);
	}


}
