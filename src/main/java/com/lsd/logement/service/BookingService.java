package com.lsd.logement.service;

import java.util.Map;

import com.lsd.logement.entity.finance.Payement;
import com.lsd.logement.entity.reservation.Booking;

public interface BookingService extends GenericService<Booking, Integer> {

    Booking save(Booking entity, Integer appUserId);

    Booking addPayment(Integer bookingId, Payement payement);

    Booking removePayment(Integer bookingId, Payement payement);

    Map<String, Object> bookingStats();

    Booking cancelBooking(Integer bookingId);

    int countAllAvailable();
}
