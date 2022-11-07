package com.ust.contact_service.entity;

public class Contact {
	
	private Long cid;
	private String email;
	private String contactname;
	private Long userid;
	
	public Contact()
	{
		
	}
	public Contact(Long cid, String email, String contactname, Long userid) {
		super();
		this.cid = cid;
		this.email = email;
		this.contactname = contactname;
		this.userid = userid;
	}
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
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
