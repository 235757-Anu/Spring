package com.ust.contact_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ust.contact_service.entity.Contact;
//import com.ust.user_service.entity.User;

@Service

public class ContactServiceImpl implements ContactService {
	
	List<Contact> list=List.of(
			new Contact(1L,"abc@gmail.com","anna",1001L),
			new Contact(2L,"xyz@gmail.com","anna",1001L),
			new Contact(3L,"lmn@gmail.com","anna",1002L),
			new Contact(4L,"pqr1@gmail.com","anna",1002L),
			new Contact(5L,"efg@gmail.com","anna",1003L)
			);

	@Override
	public List<Contact> getContactUser(Long userid) {
		// TODO Auto-generated method stub
		return list.stream().filter(contact->contact.getUserid().equals(userid)).collect(Collectors.toList());
	}
	
	

}
