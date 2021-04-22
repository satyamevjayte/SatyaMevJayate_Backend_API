package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeSuspect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeSuspect_Repository extends JpaRepository<CrimeSuspect, BigInteger> {
}
