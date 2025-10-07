package com.ticketbookingapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Booking {
	@Id
	@GeneratedValue(generator = "booking_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq", initialValue = 151, allocationSize = 151)
	private Integer bookingId;

	private int numberOfSeats;
//	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime bookingTime;
	private double totalPrice;

	@Enumerated(EnumType.STRING)
	//@Column(nullable = false)
	private BookingStatus bookingStatus;
	
	private int showId;   // reference to Show service
    private int userId;   // reference to User service

//	private User user; // reference to User Service
//	private Show show; // reference to Show Service

    @ElementCollection
    @CollectionTable(name = "booking_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_number")
    private List<String> seatNumbers;

}
