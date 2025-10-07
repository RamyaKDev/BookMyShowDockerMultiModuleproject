package com.moviecatalog.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import com.moviecatalog.exception.MovieNotFoundException;
import com.moviecatalog.model.Movie;
import com.moviecatalog.model.MovieDto;
import com.moviecatalog.repository.IMovieRepository;

@Service
public class MovieServiceImpl implements IMovieService {

	private final ModelMapper mapper;

	private final IMovieRepository movieRepository;

	public MovieServiceImpl(ModelMapper mapper, IMovieRepository movieRepository) {
		
		this.mapper = mapper;
		this.movieRepository = movieRepository;
	}

	

	@Override
	public void addMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		movieRepository.save(movie);

	}

	@Override
	public void updateMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		movieRepository.save(movie);

	}

	@Override
	public void deleteMovie(int movieId) {
		movieRepository.deleteById(movieId);
	}

	@Override
	public List<MovieDto> getAll() {
		List<Movie> movies = movieRepository.findAll();
		return movies.stream().map((movie) -> mapper.map(movie, MovieDto.class)).toList();
	}

	@Override
	public MovieDto getByMovieId(int movieId) throws MovieNotFoundException {
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("invalid id"));
		MovieDto movieDto = mapper.map(movie, MovieDto.class);
		return movieDto;
	}

	@Override
	public List<MovieDto> getByMovieTitle(String movieTitle) throws MovieNotFoundException {
		List<Movie> movies = movieRepository.findByMovieTitle(movieTitle);
		if (movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified movieTitle");
		return movies.stream().map((movie) -> mapper.map(movie, MovieDto.class)).toList();

	}

	@Override
	public List<MovieDto> getByGenres(String genres) throws MovieNotFoundException {
		List<Movie> movies = movieRepository.findByGenres(genres);
		if (movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified genres");
		return movies.stream().map((movie) -> mapper.map(movie, MovieDto.class)).toList();
	}

	@Override
	public List<MovieDto> getByLanguages(String languages) throws MovieNotFoundException {
		List<Movie> movies = movieRepository.findByLanguages(languages);
		if (movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified languages");
		return movies.stream().map((movie) -> mapper.map(movie, MovieDto.class)).toList();
	}

}
