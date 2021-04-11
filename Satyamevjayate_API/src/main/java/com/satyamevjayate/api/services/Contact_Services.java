package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.repo.Contact_Repository;

@Service
public class Contact_Services {
	
	@Autowired
	private Contact_Repository contact_repo;
	
	public List<Contact> listAllContact()
	{
		return contact_repo.findAll();
	}
	
	public void saveContact(Contact contact)
	{
		contact_repo.save(contact);
	}
	
	public Contact getContact(BigInteger Id)
	{
		return contact_repo.findById(Id).get();
	}
	
	public void deleteContact(BigInteger Id)
	{
		contact_repo.deleteById(Id);
	}
	
	
	
	
	

}
