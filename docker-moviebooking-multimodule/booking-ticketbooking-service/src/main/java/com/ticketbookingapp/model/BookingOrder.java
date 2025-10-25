package com.ticketbookingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOrder {
    private int bookingId;
    private int userId;
    private String email;
    private double totalPrice;
    private String status;// e.g. BOOKED, CANCELLED
}
