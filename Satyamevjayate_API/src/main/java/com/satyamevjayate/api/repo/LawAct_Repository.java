package com.satyamevjayate.api.repo;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import com.satyamevjayate.api.entity.LawAct;

public interface LawAct_Repository extends JpaRepository<LawAct,BigInteger> {

}
