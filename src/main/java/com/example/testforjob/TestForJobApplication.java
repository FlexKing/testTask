package com.example.testforjob;

import com.example.testforjob.entities.Booking;
import com.example.testforjob.entities.Coworking;
import com.example.testforjob.entities.Room;
import com.example.testforjob.services.BookingService;
import com.example.testforjob.services.CoworkingService;
import com.example.testforjob.services.RoomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootApplication
public class TestForJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestForJobApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(CoworkingService coworkingService, RoomService roomService, BookingService bookingService) {
        return args -> {
            Coworking coworking = new Coworking(1L,"Coworking Center", "123 Main St", "123-456-7890");
            coworkingService.saveCoworking(coworking);

            LocalDateTime now = LocalDateTime.now();

            Room room1 = new Room(1L,"Meeting Room 1", 10, coworking);
            roomService.saveRoom(room1);
            Booking booking1 = bookingService.createBooking( room1, now.plusHours(1), now.plusHours(2));
            room1.setBookings(Collections.singletonList(booking1));



            Room room2 = new Room(2L,"Conference Room", 20, coworking);
            roomService.saveRoom(room2);
            Booking booking2 = bookingService.createBooking(room2, now.plusHours(3), now.plusHours(4));
            room2.setBookings(Collections.singletonList(booking2));

        };
    }
}
