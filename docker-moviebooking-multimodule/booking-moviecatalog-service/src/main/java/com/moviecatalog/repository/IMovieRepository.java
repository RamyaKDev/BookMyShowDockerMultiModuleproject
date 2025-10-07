package com.moviecatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviecatalog.model.Movie;



@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer>{
	

	
	//No need JPQL query as they are derived queries
	
	
//	@Query("from Movie m where m.movieTitle like ?1 ")
		List<Movie> findByMovieTitle(String movieTitle);

	//@Query("from Movie m inner join genre g where m.genres=?1  ")
		List<Movie> findByGenres(String genres);

	//@Query("from Movie m inner join language l where m.languages=?1 ")
		List<Movie> findByLanguages(String languages);
	
	
    
}
