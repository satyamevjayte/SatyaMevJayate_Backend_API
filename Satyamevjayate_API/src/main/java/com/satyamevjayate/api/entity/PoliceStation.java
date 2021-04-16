package com.satyamevjayate.api.entity;

import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name="policestation")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="PoliceStationID")
    private BigInteger PoliceStationID;
    @Column(name="StationName")
    private String StationName;
    @Column(name="AddressID")
    private BigInteger AddressID;

    @Column(name="ContactID")
    private BigInteger ContactID;


    //    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Addresses Address;
//
//    public Addresses getAddress() {
//        return Address;
//    }
//
//    public void setAddress(Addresses address) {
//        Address = address;
//    }
//
//
//
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Contact contact;
//    public Contact getContact() {
//        return contact;
//    }
//
//    public void setContact(Contact contact) {
//        this.contact = contact;
//    }
    public PoliceStation() {
    }

    public PoliceStation(BigInteger policeStationID, String stationName, BigInteger addressID, BigInteger contactID) {
        PoliceStationID = policeStationID;
        StationName = stationName;
        AddressID = addressID;
        ContactID = contactID;
    }

    public BigInteger getAddressID() {
        return AddressID;
    }

    public void setAddressID(BigInteger addressID) {
        AddressID = addressID;
    }

    public BigInteger getContactID() {
        return ContactID;
    }

    public void setContactID(BigInteger contactID) {
        ContactID = contactID;
    }

    public BigInteger getPoliceStationID() {
        return PoliceStationID;
    }

    public void setPoliceStationID(BigInteger policeStationID) {
        PoliceStationID = policeStationID;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }


}
