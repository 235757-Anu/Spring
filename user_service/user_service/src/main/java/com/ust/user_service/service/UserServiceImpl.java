package com.ust.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.user_service.entity.User;

@Service

public class UserServiceImpl implements UserService{

	List<User> list=List.of(
			new User(1001L,"ANU","9876543210"),
			new User(1002L,"KARTHIKA","7034674969"),
			new User(1003L,"NIVIYA","6282957459"),
			new User(1004L,"SUHAIL","9048792345")
			);
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user->user.getUserid().equals(id)).findAny().orElse(null);
	}

}
