package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.services.Contact_Services;

@RestController
public class Controller_Contact {
	
	@Autowired
	private Contact_Services contact_Services;
	
	@GetMapping("/GetAllContact")
	public List<Contact> getAllContact() {
		return contact_Services.listAllContact();
	}
	
	@GetMapping("/GetContact/{id}")
	public Contact getAddresses(@PathVariable BigInteger id)
	{
		Contact contact= contact_Services.getContact(id);
		return contact;
	}
	
	@PostMapping("/AddContact")
	public String addContact(@RequestBody Contact contact)
	{
		contact_Services.saveContact(contact);;
		return "Contact Add Successfully";
	}	
	
	
	@DeleteMapping("/DeleteContact/{id}")
	public String deleteContact(@PathVariable BigInteger id)
	{
		contact_Services.deleteContact(id);;
	    return "Delete Contact Successfully";
	}
	

}
