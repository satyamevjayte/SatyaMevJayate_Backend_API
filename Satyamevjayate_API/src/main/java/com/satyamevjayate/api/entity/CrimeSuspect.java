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
//    @Column(name="CrimeID")
//    private BigInteger CrimeID;
//    @Column(name="AddressID")
//    private BigInteger AddressID;
//    @Column(name="PersonID")
//    private BigInteger PersonID;
//    @Column(name="ContactID")
//    private BigInteger ContactID;
    
    @ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="AddressID"), name = "AddressId",insertable=false, updatable=false)
    private Addresses susaddress;
	
    @ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="CrimeID"), name = "CrimeId")
    private Crime crimeid;
    
	@ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="ContactID"), name = "ContactId",insertable=false, updatable=false)
    private Contact suscontact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person susperson;
	
	
	 @OneToMany(mappedBy = "crimesusdoc", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnore
	 private List<CrimeSuspectDocument> crimesuspectdocument;

}
