package com.ticketbookingapp.model;


import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDto {
	private Integer BookingId;
	private int numberOfSeats;
	private LocalDateTime bookingTime;
	private double totalPrice;
	private BookingStatus bookingStatus;

	private int userId; // reference to User Service
	private int showId; // reference to Show Service
	
	private List<String> seatNumbers;
    // extra field for error handling
    private String errorMessage;
}
