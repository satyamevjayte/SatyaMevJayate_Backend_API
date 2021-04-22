package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="crimeimage")
public class CrimeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CrimeImageID")
    private BigInteger CrimeImageID;
//    @Column(name="CrimeID")
//    private BigInteger CrimeID;
    
    @ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="CrimeID"), name = "CrimeId",insertable=false, updatable=false)
    private Crime crmImage;
    
    @Column(name="CrimeImage")
    private Byte[] CrimeImage;
}
