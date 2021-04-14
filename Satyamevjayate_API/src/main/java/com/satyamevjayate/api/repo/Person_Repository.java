package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface Person_Repository extends JpaRepository<Person, BigInteger> {
}
