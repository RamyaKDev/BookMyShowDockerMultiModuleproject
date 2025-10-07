package com.theatreapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theatreapp.model.Theatre;

@Repository
public interface ITheatreRepository extends JpaRepository<Theatre, Integer> {
	List<Theatre> findByLocation(String location);

}
