package com.satyamevjayate.api.entity;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WorkerID")
    private BigInteger WorkerID;
    @Column(name="DateOfJoining")
    private Date DateOfJoining;
    @Column(name="DateOfResign")
    private Date DateOfResign;
//    @Column(name="AddressID")
//    private BigInteger AddressID;
//    @Column(name="PersonID")
//    private BigInteger PersonID;
//    @Column(name="ContactID")
//    private BigInteger ContactID;
    
    
    @OneToOne(optional=false)
    @JoinColumn( name = "AddressID")
    private Addresses workeraddress;
	
	@OneToOne(optional=false)
    @JoinColumn( name = "ContactID")
    private Contact workercontact;
	
	@OneToOne(optional=false)
    @JoinColumn(name = "PersonID")
    private Person workerperson;
	
	@OneToOne(mappedBy = "workerdoc")
	@JsonIgnore
	private WorkerDocument workerdocument;

}
