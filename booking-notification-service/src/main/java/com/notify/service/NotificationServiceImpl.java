package com.notify.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notify.model.BookingOrderEvent;


@Service
public class NotificationServiceImpl implements INotificationService {

	 @Autowired
	    private JavaMailSender mailSender;

	    @KafkaListener(topics = "booking-topic", groupId = "notification-group",containerFactory="containerFactory")
	    public void consume(BookingOrderEvent event) {
	        System.out.println(" Received booking event: " + event);

	        sendEmail(event);
	    }

	    private void sendEmail(BookingOrderEvent event) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(event.getBookingOrder().getEmail());
	            message.setSubject("Movie Ticket " + event.getStatus());
	            message.setText("Dear User,\n\n" + event.getMessage() +
	                    "\n\nBooking ID: " + event.getBookingOrder().getBookingId() +
	                    "\nTotal Price: $" + event.getBookingOrder().getTotalPrice() +
	                    "\n\nThank you for using BookMyShow!");

	            mailSender.send(message);
	            System.out.println("Email sent successfully to " + event.getBookingOrder().getEmail());
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Failed to send email");
	        }
	    }
	}