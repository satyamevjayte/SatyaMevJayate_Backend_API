package com.satyamevjayate.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PersonId")
    private BigInteger PersonId;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="LastName")
    private String LastName;

    @Column(name="DateOfBirth")
    private Date DateOfBirth;

    @Column(name="Gender")
    private String Gender;

    @Column(name="PersonImage")
    private byte[] PersonImage;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Police> police;
    
    @OneToOne(mappedBy = "susperson")
    @JsonIgnore
    private CrimeSuspect crimesuspect;
    
    
    @OneToMany(mappedBy = "victimperson")
    @JsonIgnore
    private List<CrimeVictim> crimevictim;
    
    @OneToMany(mappedBy = "criminalperson")
    @JsonIgnore
    private List<Criminal> criminal;
    
    @OneToMany(mappedBy = "workerperson")
    @JsonIgnore
    private List<Worker> worker;
    
    public Person() {
    }

    public Person(BigInteger personId, String firstName, String lastName, Date dateOfBirth, String gender, byte[] personImage) {
        PersonId = personId;
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        PersonImage = personImage;
    }

    public BigInteger getPerson_Id() {
        return PersonId;
    }

    public void setPerson_Id(BigInteger person_Id) {
        PersonId = person_Id;
    }

    public String getFirst_Name() {
        return FirstName;
    }

    public void setFirst_Name(String first_Name) {
        FirstName = first_Name;
    }

    public String getLast_Name() {
        return LastName;
    }

    public void setLast_Name(String last_Name) {
        LastName = last_Name;
    }

    public Date getDate_of_birth() {
        return DateOfBirth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.DateOfBirth = date_of_birth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public byte[] getPerson_Image() {
        return PersonImage;
    }

    public void setPerson_Image(byte[] person_Image) {
        PersonImage = person_Image;
    }
}