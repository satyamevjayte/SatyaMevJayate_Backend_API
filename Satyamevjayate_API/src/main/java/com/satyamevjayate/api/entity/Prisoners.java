package com.satyamevjayate.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.satyamevjayate.api.entity.Prison.PrisonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="prisoners")
public class Prisoners {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrisonerID")
   private Long PrisonerID;
 
 @Column(name="CrimeID")
   private Long CrimeID;
 
 @Column(name="CriminalID")
   private Long CriminalID;
 
 @Column(name="PrisoningTypeID")
 private Long PrisoningTypeID;
 
 @Column(name="PrisonID")
 private Long PrisonID;
 
 @Column(name="PrisioningStartDate")
 private Date PrisioningStartDate;
 
 @Column(name="PrisioningEndDate")
 private Date PrisioningEndDate;
 
 @Column(name="PrisonStatus")
 private String PrisonStatus;

}
