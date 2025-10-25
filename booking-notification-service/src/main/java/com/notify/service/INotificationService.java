package com.notify.service;

import com.notify.model.BookingOrderEvent;

public interface INotificationService {
void consume(BookingOrderEvent event);
}
