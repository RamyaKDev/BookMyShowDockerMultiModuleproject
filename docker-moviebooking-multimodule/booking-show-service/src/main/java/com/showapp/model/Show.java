package com.showapp.model;





import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movie_show")  
public class Show {
	@Id
	@GeneratedValue(generator = "movieshow_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movieshow_gen", sequenceName = "movieshow_seq", initialValue = 101, allocationSize = 1)
	private Integer showId;

	private String movieTitle;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate showDate;
    private LocalTime showTime;
    private double price;
    private int movieId;
    private int theatreId;
    private int totalNoOfSeats;
    
    
}
    
    



    
//    // Available seat numbers for this show
//    @ElementCollection
//    @CollectionTable(name = "show_seats", joinColumns = @JoinColumn(name = "show_id"))
//    @Column(name = "seat_number")
//    private List<String> seatNumbers ;

//    // Booked seats for this show
//    @ElementCollection
//    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "show_id"))
//    @Column(name = "seat_number")
//    private List<String> bookedSeats ;


