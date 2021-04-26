package com.satyamevjayate.api.model;

import com.satyamevjayate.api.entity.CrimeSuspect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crimesuspectmodel {
    private String message;
    private List<CrimeSuspect> crimeSuspect;
}
