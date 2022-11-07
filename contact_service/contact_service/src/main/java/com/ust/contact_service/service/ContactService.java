package com.ust.contact_service.service;

import java.util.List;

import com.ust.contact_service.entity.Contact;

public interface ContactService {
	
	public List<Contact> getContactUser(Long userid);

}

