package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crimetype")
public class CrimeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CrimeTypeID")
	private BigInteger CrimeTypeId;
	
	@Column(name="CrimeType")
	private String CrimeType;
	
	public CrimeType()
	{
		
	}
	
	public CrimeType(BigInteger crimeTypeId, String crimeType) {
		super();
		CrimeTypeId = crimeTypeId;
		CrimeType = crimeType;
	}

	
	public BigInteger getCrimeTypeId() {
		return CrimeTypeId;
	}
	public void setCrimeTypeId(BigInteger crimeTypeId) {
		CrimeTypeId = crimeTypeId;
	}
	public String getCrimeType() {
		return CrimeType;
	}
	public void setCrimeType(String crimeType) {
		CrimeType = crimeType;
	}
	

}
