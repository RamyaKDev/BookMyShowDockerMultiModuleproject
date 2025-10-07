package com.showapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showapp.model.Show;

public interface IShowRepository extends JpaRepository<Show, Integer>{
	 List<Show> findByMovieId(int movieId);
	 List<Show> findByTheatreId(int theatreId);
}
