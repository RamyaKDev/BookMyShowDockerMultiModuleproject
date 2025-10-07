package com.moviecatalog.service;
import java.util.List;

import com.moviecatalog.exception.MovieNotFoundException;
import com.moviecatalog.model.MovieDto;



public interface IMovieService {
	//CRUD Operations
		void addMovie(MovieDto movieDto);
		void updateMovie(MovieDto movieDto);
		void deleteMovie(int movieId);
		List<MovieDto> getAll();
		MovieDto getByMovieId(int movieId) throws MovieNotFoundException;
		
	//Derived methods	
	
		
		List<MovieDto> getByMovieTitle(String movieTitle) throws MovieNotFoundException;
		List<MovieDto> getByGenres(String genres) throws MovieNotFoundException;
		List<MovieDto> getByLanguages(String languages) throws MovieNotFoundException;
		
	
		
}
