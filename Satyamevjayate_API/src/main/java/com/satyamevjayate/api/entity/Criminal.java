package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "criminal")
public class Criminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CriminalID")
    private Long CriminalID;
//    @Column(name = "PersonID")
//    private Long PersonID;
//    @Column(name = "ContactID")
//    private Long ContactID;
//    @Column(name = "AddressID")
//    private Long AddressID;
    
    
    
    
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses criminaladdress;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "ContactID")
    private Contact criminalcontact;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person criminalperson;
	
	
	@OneToOne(mappedBy = "criminaldoc")
    @JsonIgnore
    private CriminalDocument criminaldocument;
	
    @Column(name = "Height")
    private Long Height;
    @Column(name = "Weight")
    private Long Weight;
    @Column(name = "Type")
    private Long Type;

}
