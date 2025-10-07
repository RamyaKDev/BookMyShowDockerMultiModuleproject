package com.theatreapp.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
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
public class Theatre {
	@Id
	@GeneratedValue(generator = "theatre_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "theatre_gen", sequenceName = "theatre_seq", initialValue = 51, allocationSize = 1)
	private Integer theatreId;
	private String theatreName;
	private String location;	
	
	
	
}
	// private int theatreCapacity;
	 
//	 // Seat layout for this theatre (master list)
//    @ElementCollection
//    @CollectionTable(name = "theatre_seats", joinColumns = @JoinColumn(name = "theatre_id"))
//    @Column(name = "total_seats")
//    private List<String> totalSeats;
//    //private List<String> seatNumbers = new ArrayList<>();

	

