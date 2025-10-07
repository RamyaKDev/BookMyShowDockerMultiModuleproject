package com.ticketbookingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbookingapp.model.Booking;
import com.ticketbookingapp.model.BookingStatus;


public interface IBookingRepository extends JpaRepository<Booking, Integer>{
	  	List<Booking> findByUserId(int userId);
	    List<Booking> findByShowId(int showId);
		List<Booking> findByBookingStatus(BookingStatus bookingStatus);
	    
}
