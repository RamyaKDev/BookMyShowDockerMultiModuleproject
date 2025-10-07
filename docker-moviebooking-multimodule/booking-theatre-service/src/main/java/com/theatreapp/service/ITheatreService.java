package com.theatreapp.service;



import java.util.List;

import com.theatreapp.exception.TheatreNotFoundException;
import com.theatreapp.model.TheatreDto;

public interface ITheatreService {
	
			void addTheatre(TheatreDto theatreDto);
			void updateTheatre(TheatreDto theatreDto);
			void deleteTheatre(int theatreId);			
			TheatreDto getByTheatreId(int theatreId) throws TheatreNotFoundException;
			List<TheatreDto> getAll();
			List<TheatreDto> getTheatresByLocation(String location) throws TheatreNotFoundException;
			
}
