package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="crimesuspectdocument")
public class CrimeSuspectDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private BigInteger DocumentID;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "CrimeSuspectID")
    private CrimeSuspect crimesusdoc;
    
  
//  @Column(name="CrimeSuspectID")
//  private BigInteger CrimeSuspectID;
    @Column(name="DocumentType")
    private String DocumentType;
    @Column(name="DocumentImage")
    private Byte[] DocumentImage;
    @Column(name="Description")
    private String Description;
    @Column(name="UploadDateTime")
    private Date UploadDateTime;

}
