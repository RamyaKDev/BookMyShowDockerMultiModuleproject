package com.showapp.model;





import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ShowDto {
	private Integer showId;

	private String movieTitle;
    private LocalDate showDate;
    private LocalTime showTime;
    private double price;
    private int movieId;
    private int theatreId;
    private int totalNoOfSeats;
   // private List<String> bookedSeats ;
    
}
