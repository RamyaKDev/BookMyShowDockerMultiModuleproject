package com.theatreapp.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.theatreapp.exception.TheatreNotFoundException;
import com.theatreapp.model.TheatreDto;
import com.theatreapp.service.ITheatreService;

@RestController
@RequestMapping("/theatres-service/v1")
public class TheatreController {
		
		public TheatreController(ITheatreService theatreService) {
		super();
		this.theatreService = theatreService;
	}
		private final ITheatreService theatreService;
		
		// http://localhost:8082/theatres-service/v1/admin/theatres
		@PostMapping("/admin/theatres")
		ResponseEntity<Void> addTheatre(@RequestBody TheatreDto theatreDto) {
			theatreService.addTheatre(theatreDto);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Theatre Inserted");
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

		}

		// http://localhost:8082/theatres-service/v1/admin/theatres
		@PutMapping("/admin/theatres")
		ResponseEntity<Void> updateTheatre(@RequestBody TheatreDto theatreDto) {
			theatreService.updateTheatre(theatreDto);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Theatre updated by Id");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

		}

		// http://localhost:8082/theatres-service/v1/admin/theatres/theatreId/52
		@DeleteMapping("/admin/theatres/theatreId/{theatreId}")
		ResponseEntity<Void> deleteTheatre(@PathVariable int theatreId) {
			theatreService.deleteTheatre(theatreId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Theatre deleted by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

		}

		

		// http://localhost:8082/theatres-service/v1/theatres/theatreId?theatreId=51
		@GetMapping("/theatres/theatreId")
		ResponseEntity<TheatreDto> getByTheatreId(@RequestParam int theatreId) throws TheatreNotFoundException {
			TheatreDto theatreDto = theatreService.getByTheatreId(theatreId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Getting theatre by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatreDto);
		}

		
		// http://localhost:8082/theatres-service/v1/theatres
		@GetMapping("/theatres")
		ResponseEntity<List<TheatreDto>> getAll() {
			List<TheatreDto> theatreDto = theatreService.getAll();
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Getting all theatres");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatreDto);

		}
		// http://localhost:8082/theatres-service/v1/theatres/location/chennai
		@GetMapping("/theatres/location/{location}")
		ResponseEntity<List<TheatreDto>> getTheatresByLocation(@PathVariable  String location)throws TheatreNotFoundException{
			List<TheatreDto> theatreDto=theatreService.getTheatresByLocation(location);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Getting all theatres by location");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatreDto);
			
			}
	}


