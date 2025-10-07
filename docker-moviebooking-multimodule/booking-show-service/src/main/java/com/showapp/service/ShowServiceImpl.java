package com.showapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.showapp.exception.MovieNotFoundException;
import com.showapp.exception.ShowNotFoundException;
import com.showapp.exception.TheatreNotFoundException;
import com.showapp.feignClient.IMovieFeignClient;
import com.showapp.feignClient.ITheatreFeignClient;
import com.showapp.model.Movie;
import com.showapp.model.Show;
import com.showapp.model.ShowDto;
import com.showapp.model.Theatre;
import com.showapp.repository.IShowRepository;

@Service
public class ShowServiceImpl implements IShowService {

	private final ModelMapper mapper;

	private final IShowRepository showRepository;
	private final IMovieFeignClient movieClient;
	private final ITheatreFeignClient theatreClient;

	

	public ShowServiceImpl(ModelMapper mapper, IShowRepository showRepository, IMovieFeignClient movieClient,
			ITheatreFeignClient theatreClient) {
		super();
		this.mapper = mapper;
		this.showRepository = showRepository;
		this.movieClient = movieClient;
		this.theatreClient = theatreClient;
	}

	public void addShow(ShowDto showDto) {

		// validate movie exists
		Movie movie = movieClient.getByMovieId(showDto.getMovieId());

		// validate theatre exist
		Theatre theatre = theatreClient.getByTheatreId(showDto.getTheatreId());
		if (movie == null)
			throw new MovieNotFoundException("No movie found ");
		
		if (theatre == null)
			throw new TheatreNotFoundException("No theatre found ");

		Show show = mapper.map(showDto, Show.class);
		
		showRepository.save(show);

	}

	@Override
	public ShowDto getShowById(int showId) {
		Show show = showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("invalid id"));
		ShowDto showDto = mapper.map(show, ShowDto.class);
		return showDto;
	}

	@Override
	public List<ShowDto> getShowsByMovie(int movieId) {
		List<Show> shows = showRepository.findByMovieId(movieId);
		if (shows.isEmpty())
			throw new ShowNotFoundException("No show found in the specified movieid");
		return shows.stream().map((show) -> mapper.map(show, ShowDto.class)).toList();
	}

	@Override
	public List<ShowDto> getShowsByTheatre(int theatreId) {
		List<Show> shows = showRepository.findByTheatreId(theatreId);
		if (shows.isEmpty())
			throw new ShowNotFoundException("No show found in the specified theatreId");
		return shows.stream().map((show) -> mapper.map(show, ShowDto.class)).toList();
	}

	@Override
	public void deleteShow(int showId) {
		showRepository.deleteById(showId);

	}

	@Override
	public List<ShowDto> getAllShows() {
		List<Show> shows = showRepository.findAll();
		return shows.stream().map((show) -> mapper.map(show, ShowDto.class)).toList();
	}

	@Override
	public void updateShow(ShowDto showDto) {

		// validate movie exists
		Movie movie = movieClient.getByMovieId(showDto.getMovieId());

		// validate theatre exist
		Theatre theatre = theatreClient.getByTheatreId(showDto.getTheatreId());
		if (movie == null)
			throw new MovieNotFoundException("No movie found ");

		if (theatre == null)
			throw new TheatreNotFoundException("No theatre found ");

		Show show = mapper.map(showDto, Show.class);
		showRepository.save(show);
	}

	

	
}