package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prisoningtype")
public class PrisoningType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PrisoningTypeId")
	private BigInteger PrisoningTypeId;
	
	@Column(name="Name")
	private String Name;
	
	public PrisoningType()
	{
		
	}
	public PrisoningType(BigInteger prisoningTypeId, String name) {
		super();
		PrisoningTypeId = prisoningTypeId;
		Name = name;
	}
	
	
	public BigInteger getPrisoningTypeId() {
		return PrisoningTypeId;
	}
	public void setPrisoningTypeId(BigInteger prisoningTypeId) {
		PrisoningTypeId = prisoningTypeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	

}
