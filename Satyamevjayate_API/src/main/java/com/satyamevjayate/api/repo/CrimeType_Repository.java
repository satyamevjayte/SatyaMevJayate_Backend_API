package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.CrimeType;

public interface CrimeType_Repository extends JpaRepository<CrimeType,BigInteger>{

}
