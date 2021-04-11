package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressID")
	private BigInteger AddressID;
	
	@Column(name="AddressLine1")
	private String AddressLine1;
	
	@Column(name="AddressLine2")
	private String AddressLine2;
	
	@Column(name="ZipCode")
	private int ZipCode;
	
	@Column(name="City")
	private String City;
	
	@Column(name="State")
	private String State;
	
	@Column(name="Country")
	private String Country;
	
	public Addresses()
	{
		
	}
	public Addresses(BigInteger addressID, String addressLine1, String addressLine2, int zipCode, String city,
			String state, String country) {
		super();
		AddressID = addressID;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		ZipCode = zipCode;
		City = city;
		State = state;
		Country = country;
	}

	
	public BigInteger getAddressID() {
		return AddressID;
	}
	public void setAddressID(BigInteger addressID) {
		AddressID = addressID;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
	
	

}
