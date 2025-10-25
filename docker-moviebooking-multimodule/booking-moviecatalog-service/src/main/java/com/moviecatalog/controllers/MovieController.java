package com.moviecatalog.controllers;

import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalog.exception.MovieNotFoundException;
import com.moviecatalog.model.MovieDto;
import com.moviecatalog.service.IMovieService;

@RestController
@RequestMapping("/movies-service/v1")
public class MovieController {
	private final IMovieService movieService ;

	public MovieController(IMovieService movieService) {
		super();
		this.movieService = movieService;
	}

	// http://localhost:8081/movies-service/v1/admin/movies
	@PostMapping("/admin/movies")
	ResponseEntity<Void> addMovie(@RequestBody MovieDto movieDto) {
		movieService.addMovie(movieDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Movie Inserted");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

	}

	// http://localhost:8081/movies-service/v1/admin/movies
	@PutMapping("/admin/movies")
	ResponseEntity<Void> updateMovie(@RequestBody MovieDto movieDto) {
		movieService.updateMovie(movieDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Movie updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

	}

	// http://localhost:8081/movies-service/v1/admin/movies/movieId/2
	@DeleteMapping("/admin/movies/movieId/{movieId}")
	ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
		movieService.deleteMovie(movieId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Movie deleted by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

	}

	// http://localhost:8081/movies-service/v1/movies
	@GetMapping("/movies")
	ResponseEntity<List<MovieDto>> getAll() {
		List<MovieDto> movieDto = movieService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting all movies");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);

	}

	// http://localhost:8081/movies-service/v1/movies/movieId?movieId=1
	@GetMapping("/movies/movieId")
	ResponseEntity<MovieDto> getByMovieId(@RequestParam int movieId) throws MovieNotFoundException {
		MovieDto movieDto = movieService.getByMovieId(movieId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting movie by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
	}

	// http://localhost:8081/movies-service/v1/movies/title/3BHK
	@GetMapping("/movies/title/{title}")
	ResponseEntity<List<MovieDto>> getByMovieTitle(@PathVariable("title") String movieTitle)
			throws MovieNotFoundException {
		List<MovieDto> movieDto = movieService.getByMovieTitle(movieTitle);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting movie by movie title");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);

	}

	// http://localhost:8081/movies-service/v1/movies/genre/Action
	@GetMapping("/movies/genre/{genres}")
	ResponseEntity<List<MovieDto>> getByGenres(@PathVariable String genres) throws MovieNotFoundException {
		List<MovieDto> movieDto = movieService.getByGenres(genres);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting movie by movie genre");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);

	}

	// http://localhost:8081/movies-service/v1/movies/language/Tamil
	@GetMapping("/movies/language/{languages}")
	ResponseEntity<List<MovieDto>> getByLanguages(@PathVariable String languages) throws MovieNotFoundException {
		List<MovieDto> movieDto = movieService.getByLanguages(languages);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Getting movie by languages");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);

	}

}
