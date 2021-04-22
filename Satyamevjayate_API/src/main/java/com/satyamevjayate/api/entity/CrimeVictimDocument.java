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
@Table(name = "crimevictimdocument")
public class CrimeVictimDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DocumentID")
    private BigInteger DocumentID;
//    @Column(name="CrimeVictimID")
//    private BigInteger CrimeVictimID;
    
    
    @ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="CrimeVictimID"), name = "CrimeVictimId",insertable=false, updatable=false)
    private CrimeVictim crmvictimdocID;

    @Column(name="DocumentType")
    private String DocumentType;
    @Column(name="DocumentImage")
    private Byte[] DocumentImage;
    @Column(name="Description")
    private String Description;
    @Column(name="UploadDateTime")
    private Date UploadDateTime;
}
