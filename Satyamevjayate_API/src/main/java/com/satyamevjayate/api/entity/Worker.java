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
    
    
    @ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="AddressID"), name = "AddressId",insertable=false, updatable=false)
    private Addresses workeraddress;
	
	@ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="ContactID"), name = "ContactId",insertable=false, updatable=false)
    private Contact workercontact;
	
	@ManyToOne(optional=false)
    @JoinColumn(foreignKey = @ForeignKey(name="PersonID"), name = "PersonId",insertable=false, updatable=false)
    private Person workerperson;
	
	@OneToMany(mappedBy = "workerdoc", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<WorkerDocument> workerdocument;

}
