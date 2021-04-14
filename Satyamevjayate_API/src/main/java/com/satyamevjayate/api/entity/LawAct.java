package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="lawact")
@Entity

public class LawAct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LawID")
	private BigInteger LawID;
	
	@Column(name="LawName")
	private String LawName;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="Punishment")
	private String Punishment;

	public BigInteger getLawID() {
		return LawID;
	}

	public void setLawID(BigInteger lawID) {
		LawID = lawID;
	}

	public String getLawName() {
		return LawName;
	}

	public void setLawName(String lawName) {
		LawName = lawName;
	}

	public String getDescription() {
		return Description;
	}

	public LawAct(BigInteger lawID, String lawName, String description, String punishment) {
		super();
		LawID = lawID;
		LawName = lawName;
		Description = description;
		Punishment = punishment;
	}

	public LawAct() {
	
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPunishment() {
		return Punishment;
	}

	public void setPunishment(String punishment) {
		Punishment = punishment;
	}
	
	
}
