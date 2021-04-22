package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.CrimeVictim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CrimeVictim_Repository extends JpaRepository<CrimeVictim, BigInteger> {
}
