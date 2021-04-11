package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ContactId")
	private BigInteger ContactId;
	
	@Column(name="ContactNumber")
	private BigInteger ContactNumber;
	
	@Column(name="ContactEmail")
	private String ContactEmail;
	
	public Contact()
	{
		
	}
	
	public Contact(BigInteger contactId, BigInteger contactNumber, String contactEmail) {
		super();
		ContactId = contactId;
		ContactNumber = contactNumber;
		ContactEmail = contactEmail;
	}
	
	
	public BigInteger getContactId() {
		return ContactId;
	}
	public void setContactId(BigInteger contactId) {
		ContactId = contactId;
	}
	public BigInteger getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(BigInteger contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getContactEmail() {
		return ContactEmail;
	}
	public void setContactEmail(String contactEmail) {
		ContactEmail = contactEmail;
	}

	
}
