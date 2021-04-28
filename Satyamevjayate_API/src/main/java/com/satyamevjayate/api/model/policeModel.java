package com.satyamevjayate.api.model;

import java.util.List;

import com.satyamevjayate.api.entity.Police;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class policeModel {
	
	 private String message;
	 private List<Police> police;

}
