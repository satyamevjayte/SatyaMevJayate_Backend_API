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
@Table(name="criminal_document")
public class CriminalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private Long DocumentID;
//    @Column(name="CriminalID")
//    private Long CriminalID;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "CriminalID")
    private Criminal criminaldoc;
    
    @Column(name="DocumentType")
    private String DocumentType;
    @Column(name="DocumentImage")
    private Byte[] DocumentImage;
    @Column(name="Description")
    private String Description;
    @Column(name="UploadDateTime")
    private Date UploadDateTime;
}
