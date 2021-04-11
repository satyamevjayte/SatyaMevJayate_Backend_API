package com.satyamevjayate.api.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="policerole")
@Entity
public class PoliceRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleID")
	private BigInteger RoleID;
	@Column(name="Role_Name")
	private String RoleName;
	
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
