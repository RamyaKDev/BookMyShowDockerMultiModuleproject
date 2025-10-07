package com.showapp.service;

import java.util.List;

import com.showapp.model.Show;
import com.showapp.model.ShowDto;

public interface IShowService {
    void addShow(ShowDto showDto);

	ShowDto getShowById(int showId);

	List<ShowDto> getAllShows();

	List<ShowDto> getShowsByMovie(int movieId);

	List<ShowDto> getShowsByTheatre(int  theatreId);

	void updateShow(ShowDto showDto);

	void deleteShow(int showId);
	
	
}
