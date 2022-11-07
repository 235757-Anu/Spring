package com.ust.user_service.entity;

public class Contact {
	
	private Long cID;
	private String email;
	private String contactname;
	private Long userid;
	
	public Contact()
	{
		
	}
		
	public Contact(Long cID, String email, String contactname, Long userid) {
		super();
		this.cID = cID;
		this.email = email;
		this.contactname = contactname;
		this.userid = userid;
	}

	public Long getcID() {
		return cID;
	}
	public void setcID(Long cID) {
		this.cID = cID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

}
