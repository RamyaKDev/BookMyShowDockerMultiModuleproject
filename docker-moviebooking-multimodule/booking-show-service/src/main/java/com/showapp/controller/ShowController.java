package com.showapp.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;



import com.showapp.model.ShowDto;
import com.showapp.service.IShowService;
@RestController
@RequestMapping("/shows-service/v1/")
public class ShowController {
	
	private final IShowService showService;
	 
		public ShowController(IShowService showService) {	
		this.showService = showService;
	}
		// http://localhost:8083/shows-service/v1/admin/shows
	    @PostMapping("/admin/shows")
	    public ResponseEntity<Void> addShow(@RequestBody ShowDto showDto) {
	    	showService.addShow(showDto);
	    	HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Show Inserted");
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	    }

	    // http://localhost:8083/shows-service/v1/shows/showId/101
	    @GetMapping("/shows/showId/{showId}")
	    public ResponseEntity<ShowDto> getShowById(@PathVariable int showId) {
	    	ShowDto showDto = showService.getShowById(showId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Getting show by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(showDto);
	    }

	    // http://localhost:8083/shows-service/v1/shows
	    @GetMapping("/shows")
	    public ResponseEntity<List<ShowDto>> getAllShows() {
	    	List<ShowDto> showDto = showService.getAllShows();
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Getting all movies");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(showDto);
	    }

	    // http://localhost:8083/shows-service/v1/shows/movieId/1
	    @GetMapping("/shows/movieId/{movieId}")
	    public ResponseEntity<List<ShowDto>> getShowsByMovie(@PathVariable int movieId) {
	        return ResponseEntity.ok(showService.getShowsByMovie(movieId));
	    }

	 // http://localhost:8083/shows-service/v1/shows/theatreId/51
	    @GetMapping("/shows/theatreId/{theatreId}")
	    public ResponseEntity<List<ShowDto>> getShowsByScreen(@PathVariable int theatreId) {
	        return ResponseEntity.ok(showService.getShowsByTheatre(theatreId));
	    }

	    // http://localhost:8083/shows-service/v1/admin/shows
	    @PutMapping("/admin/shows")
	    public ResponseEntity<ShowDto> updateShow(@RequestBody ShowDto showDto) {
	    	showService.updateShow(showDto);
			HttpHeaders headers = new HttpHeaders();
			headers.add("info", "Show updated by Id");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	    }

	 // http://localhost:8083/shows-service/v1/shows/showId/1
	    @DeleteMapping("/shows/showId/{showId}")
	    public ResponseEntity<Void> deleteShow(@PathVariable int showId) {
	    	showService.deleteShow(showId);
	        return ResponseEntity.noContent().build();
	    }
	


	

	
}
