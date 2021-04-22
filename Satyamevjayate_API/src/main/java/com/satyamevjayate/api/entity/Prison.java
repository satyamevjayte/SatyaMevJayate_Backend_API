package com.satyamevjayate.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
@Table(name="prison")
public class Prison {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrisonID")
   private Long PrisonID;
 
 @Column(name="PoliceID")
   private Long PoliceID;
 
 @Column(name="AddressID")
   private Long AddressID;
 
 @Column(name="PrisonName")
 private String PrisonName;

}
