package com.ticketbookingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOrderEvent {
    private String message;
    private String status;
    private BookingOrder bookingOrder;
}
