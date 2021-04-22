package com.satyamevjayate.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="complainer")
public class Complainer {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="ComplainerID")
	  private Long ComplainerID;
	 
	 @Column(name="DocumentID")
	  private Long DocumentID;
	 

	 @Column(name="AddressID")
	  private Long AddressID;
	 
	 @Column(name="PersonID")
	  private Long PersonID;
	 
	 @Column(name="ContactID")
	  private Long ContactID;
	 
	 @Column(name="Pwd")
	  private String Pwd;
	 
	 
	 @OneToMany(mappedBy ="complainer",cascade=CascadeType.ALL,orphanRemoval=true)
		@JsonIgnore
		private List<Complainer> complainer;
	 
}
