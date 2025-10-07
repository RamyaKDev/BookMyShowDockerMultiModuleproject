package com.ticketbookingapp.service;

import java.util.List;

import com.ticketbookingapp.model.BookingDto;
import com.ticketbookingapp.model.BookingStatus;


public interface IBookingService {
	BookingDto createBooking(BookingDto bookingDto,String jwtToken);
	BookingDto getByBookingId(int bookingId);
	List<BookingDto> getBookingsByUser(int userId);
	List<BookingDto> getBookingsByShow(int showId) ;
	void updateBooking(BookingDto bookingDto);
	String cancelBooking(int bookingId,String jwtToken);
	List<BookingDto> getByBookingStatus(BookingStatus bookingStatus);
	
}
