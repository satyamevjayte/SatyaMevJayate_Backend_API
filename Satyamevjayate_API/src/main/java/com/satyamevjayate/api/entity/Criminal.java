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
    @JoinColumn(foreignKey = @ForeignKey(name="AddressID"), name = "AddressId",insertable=false, updatable=false)
    private Addresses criminaladdress;
	
	@ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="ContactID"), name = "ContactId",insertable=false, updatable=false)
    private Contact criminalcontact;
	
	@ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="PersonID"), name = "RoleId",insertable=false, updatable=false)
    private Person criminalperson;
	
	
	@OneToMany(mappedBy = "criminaldoc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CriminalDocument> criminaldocument;
	
    @Column(name = "Height")
    private Long Height;
    @Column(name = "Weight")
    private Long Weight;
    @Column(name = "Type")
    private Long Type;

}
