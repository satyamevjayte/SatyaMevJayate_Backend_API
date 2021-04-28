package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CrimeVictim")
public class CrimeVictim {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="CrimeVictimID")
        private BigInteger CrimeVictimID;
        @Column(name="CrimeID")
        private BigInteger CrimeID;
//        @Column(name="AddressID")
//        private BigInteger AddressID;
//        @Column(name="PersonID")
//        private BigInteger PersonID;
//        @Column(name="ContactID")
//        private BigInteger ContactID;
        
        
        
        @OneToOne(optional=false)
        @JoinColumn(name = "AddressId")
        private Addresses victimaddress;
    	
//        @ManyToOne(optional=false)
//        @JoinColumn(foreignKey = @ForeignKey(name="CrimeID"), name = "CrimeId",insertable=false, updatable=false)
//        private Crime crmvictimcrimeID;
//
    	@OneToOne(optional=false)
        @JoinColumn(name = "ContactId")
        private Contact crmvictimecontact;
    	@OneToOne(optional=false)
        @JoinColumn(name = "PersonID")
        private Person victimperson;
        
    	
    	@OneToMany(mappedBy = "crmvictimdocID")
        @JsonIgnore
        private List<CrimeVictimDocument> crimevictimdocument;
    	
        @Column(name="Height")
        private Double Height;
        @Column(name="Weight")
        private Double Weight;
}
