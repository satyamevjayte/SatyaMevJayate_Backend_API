package com.satyamevjayate.api.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Person_Id")
    private BigInteger Person_Id;

    @Column(name="First_Name")
    private String First_Name;

    @Column(name="Last_Name")
    private String Last_Name;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    @Column(name="Gender")
    private String Gender;

    @Column(name="Person_Image")
    private byte[] Person_Image;

    public Person() {
    }

    public Person(BigInteger personId, String firstName, String lastName, Date dateOfBirth, String gender, byte[] personImage) {
        Person_Id = personId;
        First_Name = firstName;
        Last_Name = lastName;
        date_of_birth = dateOfBirth;
        Gender = gender;
        Person_Image = personImage;
    }

    public BigInteger getPerson_Id() {
        return Person_Id;
    }

    public void setPerson_Id(BigInteger person_Id) {
        Person_Id = person_Id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public byte[] getPerson_Image() {
        return Person_Image;
    }

    public void setPerson_Image(byte[] person_Image) {
        Person_Image = person_Image;
    }
}
