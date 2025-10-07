package com.showapp.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {
	private Integer movieId;
	private String movieTitle;
	private String description;
	private int duration; // minutes

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate releasedate;
	
	private List<String> languages;// Tamil,Telugu,Hindi

	private List<String> genres;

	private List<String> formats;
}
