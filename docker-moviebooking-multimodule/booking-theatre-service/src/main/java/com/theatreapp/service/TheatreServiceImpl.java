package com.theatreapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatreapp.exception.TheatreNotFoundException;
import com.theatreapp.model.Theatre;
import com.theatreapp.model.TheatreDto;
import com.theatreapp.repository.ITheatreRepository;

@Service
public class TheatreServiceImpl implements ITheatreService{
	
	
		private final ModelMapper mapper;

		private final ITheatreRepository theatreRepository;

		
		
		public TheatreServiceImpl(ModelMapper mapper, ITheatreRepository theatreRepository) {
			super();
			this.mapper = mapper;
			this.theatreRepository = theatreRepository;
		}

		@Override
		public void addTheatre(TheatreDto theatreDto) {
			Theatre theatre = mapper.map(theatreDto, Theatre.class);
			theatreRepository.save(theatre);

		}

		@Override
		public void updateTheatre(TheatreDto theatreDto) {
			Theatre theatre = mapper.map(theatreDto, Theatre.class);
			theatreRepository.save(theatre);
		}

		
		 @Override
		    public void deleteTheatre(int theatreId) {
			 theatreRepository.deleteById(theatreId);
		    }

		@Override
		public List<TheatreDto> getAll() {
			List<Theatre> theatres = theatreRepository.findAll();
			return theatres.stream().map((theatre) -> mapper.map(theatre, TheatreDto.class)).toList();
		}
		@Override
		public TheatreDto getByTheatreId(int theatreId) throws TheatreNotFoundException {
			Theatre theatre = theatreRepository.findById(theatreId)
					.orElseThrow(() -> new TheatreNotFoundException("invalid id"));
			TheatreDto theatreDto = mapper.map(theatre, TheatreDto.class);
			return theatreDto;
		}
		

		

		@Override
		public List<TheatreDto> getTheatresByLocation(String location) throws TheatreNotFoundException {
			List<Theatre> theatres = theatreRepository.findByLocation(location);
			if (theatres.isEmpty())
				throw new TheatreNotFoundException("No theatre found in the specified location");
			return theatres.stream().map((theatre) -> mapper.map(theatre, TheatreDto.class))
					.toList();
		}
		


	

}
