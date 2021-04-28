package com.satyamevjayate.api.model;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeVictim;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.satyamevjayate.api.entity.CrimeSuspect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crimevictimmodel {

        private String message;
        private List<CrimeVictim> crimeVictims;
}
