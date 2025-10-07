package com.moviecatalog.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;

import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(generator = "movie_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_gen", sequenceName = "movie_seq", initialValue = 1, allocationSize = 1)
	private Integer movieId;
	private String movieTitle;
	private String description;	
	private int duration; // minutes
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate releaseDate;

	@ElementCollection
	@CollectionTable(name = "language", joinColumns = @JoinColumn(name = "movie_id"))
	private List<String> languages;// Tamil,Telugu,Hindi

	@ElementCollection
	@CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "movie_id"))
	private List<String> genres;

	@ElementCollection
	@CollectionTable(name = "format", joinColumns = @JoinColumn(name = "movie_id"))
	private List<String> formats;
}