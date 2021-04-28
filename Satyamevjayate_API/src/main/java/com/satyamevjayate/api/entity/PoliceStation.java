package com.satyamevjayate.api.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="policestation")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PoliceStationID")
    private BigInteger PoliceStationID;
    @Column(name="StationName")
    private String StationName;
//    @Column(name="AddressID")
//    private BigInteger AddressID;
//    @Column(name="ContactID")
//    private BigInteger ContactID;



    @OneToOne(optional=false)
    @JoinColumn(name = "AddressID")
    private Addresses psAddress;
    
    @OneToOne(optional =false)
    @JoinColumn(name="ContactId")
    private Contact pscontact;
    
//    @OneToOne(optional=false)
//    @JoinColumn(name="ContactID")
//    private Contact psContact;
    
//    @OneToOne(optional=false)
//    @JoinColumn(name = "ContactId")
//    private Contact psContact;
    
    
   

}
