package com.ticketbookingapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbookingapp.model.BookingDto;
import com.ticketbookingapp.model.BookingStatus;
import com.ticketbookingapp.service.IBookingService;

@RestController
@RequestMapping("/bookings-service/v1/")
public class BookingController {
	 private final IBookingService bookingService;

	    public BookingController(IBookingService bookingService) {
	        this.bookingService = bookingService;
	    }
	   
	 // http://localhost:8084/bookings-service/v1/bookings
	    @PostMapping("/bookings")
	    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto,@RequestHeader("Authorization") String token) {
	    	System.out.println(bookingDto);
	    	BookingDto booking=bookingService.createBooking(bookingDto, token);
	        return ResponseEntity.ok(booking);
	    }

	    // http://localhost:8084/bookings-service/v1/bookings/bookingId/1
	    @GetMapping("/bookings/bookingId/{bookingId}")
	    public ResponseEntity<BookingDto> getBookingById(@PathVariable int bookingId) {
	    	BookingDto bookingDto=bookingService.getByBookingId(bookingId);
	        return ResponseEntity.ok(bookingDto);
	        		
	               
	    }
	    // http://localhost:8084/bookings-service/v1/bookings/userId/201
	    @GetMapping("/bookings/userId/{userId}")
	    public ResponseEntity<List<BookingDto>> getBookingsByUser(@PathVariable int userId) {
	    	List<BookingDto> bookingDto=bookingService.getBookingsByUser(userId);
	    	 return ResponseEntity.ok(bookingDto);
	    }
	    
	 // http://localhost:8084/bookings-service/v1/bookings/showId/101
	    @GetMapping("/bookings/showId/{showId}")
	    public ResponseEntity<List<BookingDto>> getBookingsByShow(@PathVariable int showId) {
	    	List<BookingDto> bookingDto=bookingService.getBookingsByShow(showId);
	    	 return ResponseEntity.ok(bookingDto);
	    }
	    
	    // http://localhost:8084/bookings-service/v1/bookings/bookingStatus/PENDING
	    @GetMapping("/bookings/bookingStatus/{bookingStatus}")
	    public ResponseEntity<List<BookingDto>> getByBookingStatus(@PathVariable BookingStatus bookingStatus) {
	    	List<BookingDto> bookingDto=bookingService.getByBookingStatus(bookingStatus);
	    	 return ResponseEntity.ok(bookingDto);
	    }
	
	    
	 // http://localhost:8084/bookings-service/v1/bookings
	    @PutMapping("/bookings")
	    public ResponseEntity<Void> updateBooking(@RequestBody BookingDto bookingDto) {
	    	System.out.println(bookingDto);
	    	bookingService.updateBooking(bookingDto);
	        return ResponseEntity.ok().build();
	    }

	    // http://localhost:8084/bookings-service/v1/bookings/bookingId/1
	    @DeleteMapping("/bookings/bookingId/{bookingId}")
	    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId,@RequestHeader("Authorization") String token) {
	    	 String response =bookingService.cancelBooking(bookingId, token);
	    	
	         return ResponseEntity.ok(response);
	    }
}
