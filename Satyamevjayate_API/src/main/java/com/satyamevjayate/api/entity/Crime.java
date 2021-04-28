package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Crime")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeID")
    private BigInteger CrimeID;
//    @Column(name="CrimeTypeID")
//    private BigInteger CrimeTypeID;
//    @Column(name="AddressID")
//    private BigInteger AddressID;
//    
    @OneToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses crmaddress;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "CrimeTypeID")
    private CrimeType crmtype;
    
    @OneToMany(mappedBy = "crmImage")
    @JsonIgnore
    private List<CrimeImage> crimeImage;
    
//    @OneToMany(mappedBy = "crimeid")
//    @JsonIgnore
//    private List<CrimeSuspect> crimesuspect;
//
//    @OneToMany(mappedBy = "crmvictimcrimeID")
//    @JsonIgnore
//    private List<CrimeVictim> crimevictim;
    
    @Column(name="CrimeDate")
    private Date CrimeDate;
    @Column(name="CrimeTime")
    private Date CrimeTime;
    @Column(name="Description")
    private String Description;

}
