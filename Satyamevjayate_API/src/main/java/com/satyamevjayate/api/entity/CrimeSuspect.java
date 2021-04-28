package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CrimeSuspect")
public class CrimeSuspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeSuspectID")

    private BigInteger CrimeSuspectID;
    @Column(name="CrimeID")
    private BigInteger CrimeID;
//    @Column(name="AddressID")
//    private BigInteger AddressID;
//    @Column(name="PersonID")
//    private BigInteger PersonID;
//    @Column(name="ContactID")
//    private BigInteger ContactID;
    
    @OneToOne (optional=false)
    @JoinColumn(name = "AddressId")
    private Addresses susaddress;
	
//    @ManyToOne(optional=false)
//    @JoinColumn(name = "CrimeId")
//    private Crime crimeid;
    
	@OneToOne(optional=false)
    @JoinColumn( name = "ContactId")
    private Contact suscontact;
	
	@OneToOne(optional=false)
    @JoinColumn( name = "PersonID")
    private Person susperson;
	
	
	 @OneToMany(mappedBy = "crimesusdoc")
	 @JsonIgnore
	 private List<CrimeSuspectDocument> crimesuspectdocument;

}
