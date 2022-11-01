package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Model.User;
import com.example.Repository.UserRepo;

@Service

public class UserService {
	
	@Autowired
	private UserRepo repo;

	public List<User> saveDetails(List<User> user) {
		// TODO Auto-generated method stub
		return repo.saveAll(user);
	}

	public List<User> getDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public String deleteDetail(int id) {
        repo.deleteById(id);
        return id + " is removed !! " ;
    }



   public User updateDetails(User user) {
        User existingUser = repo.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setPhno(user.getPhno());
        existingUser.setAddress(user.getAddress());
        return repo.save(existingUser);
    }
	

}
