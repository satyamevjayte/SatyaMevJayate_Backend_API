package com.satyamevjayate.api.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Table(name="policerole")
@Entity
public class PoliceRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleID")
	private BigInteger RoleID;
	@Column(name="RoleName")
	private String RoleName;
	
	@OneToOne(mappedBy = "policeRole")
    @JsonIgnore
    private Police police;
	
	public PoliceRole()
	{
		
	}
	public PoliceRole(BigInteger roleID, String roleName) {
		super();
		RoleID = roleID;
		RoleName = roleName;
	}
	
	
	public BigInteger getRoleID() {
		return RoleID;
	}
	public void setRoleID(BigInteger roleID) {
		RoleID = roleID;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	
	

}
