package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface Worker_Repository extends JpaRepository<Worker, BigInteger> {
}
