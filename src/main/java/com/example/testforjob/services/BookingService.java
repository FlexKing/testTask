package com.example.testforjob.services;

import com.example.testforjob.entities.Booking;
import com.example.testforjob.entities.Room;
import com.example.testforjob.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Room room, LocalDateTime start, LocalDateTime end) {
        Booking newBooking = new Booking();
        newBooking.setRoom(room);
        newBooking.setStartTime(start);
        newBooking.setEndTime(end);

        return bookingRepository.save(newBooking);
    }
    public int countConflictingBookings(Room room, LocalDateTime start, LocalDateTime end) {
        return bookingRepository.countConflictingBookings(room, start, end);
    }


}
