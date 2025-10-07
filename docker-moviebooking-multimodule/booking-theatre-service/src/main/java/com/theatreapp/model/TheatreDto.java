package com.theatreapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TheatreDto {
	
	private Integer theatreId;
	private String theatreName;
	private String location;
//	private int theatreCapacity;
	

}
