package com.satyamevjayate.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="formverification")
public class FormVerfication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FormVerificationID")
    private BigInteger FormVerifiactionID;
    @Column(name="ComplainerID")
    private BigInteger ComplainerID;
    @Column(name="PoliceID")
    private BigInteger PoliceID;
    @Column(name="WorkerID")
    private BigInteger WorkerID;
    @Column(name="ApplyDate")
    private BigInteger ApplyDate;
    @Column(name="VerifiedDate")
    private BigInteger VerifiedDate;
    @Column(name="Status")
    private BigInteger Status;

}
