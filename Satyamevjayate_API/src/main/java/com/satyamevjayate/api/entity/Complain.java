package com.satyamevjayate.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complain")
public class Complain {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ComplainID")
	    private Long ComplainID;
	    
	    @Column(name="ComplainerID")
	    private Long ComplainerID;
	    
	    @Column(name="PoliceID")
	    private Long PoliceID;
	    
	    @Column(name="Description")
	    private String Description;
	    
	    @Column(name="ComplainDateTime")
	    private Date ComplainDateTime;
	    
	    
	    
	    
	    
	    
	    
	    
	 

}
