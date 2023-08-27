package com.example.testforjob.controllers;

import com.example.testforjob.entities.Booking;
import com.example.testforjob.entities.Room;
import com.example.testforjob.services.BookingService;
import com.example.testforjob.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;

    @PostMapping("/book")
    public ResponseEntity<String> bookRoom(@RequestParam Long roomId, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        Room room = roomService.getRoomById(roomId);
        if (room == null) {
            return ResponseEntity.badRequest().body("Room not found");
        }

        // Проверка на конфликт бронирований
        int conflictingBookings = bookingService.countConflictingBookings(room, start, end);
        if (conflictingBookings > 0) {
            return ResponseEntity.badRequest().body("Room is already booked for this period");
        }

        // Создание бронирования
        Booking newBooking = bookingService.createBooking(room, start, end);
        return ResponseEntity.ok("Room booked successfully");
    }

    // Добавьте другие методы, например, отмена бронирования
}
