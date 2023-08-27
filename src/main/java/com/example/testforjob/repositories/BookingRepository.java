package com.example.testforjob.repositories;

import com.example.testforjob.entities.Booking;
import com.example.testforjob.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b " +
            "WHERE b.room = :room AND " +
            "(:end <= b.startTime OR :start >= b.endTime)")
    List<Booking> findConflictingBookings(@Param("room") Room room,
                                          @Param("start") LocalDateTime start,
                                          @Param("end") LocalDateTime end);

    @Query("SELECT COUNT(b) FROM Booking b " +
            "WHERE b.room = :room AND " +
            "(:end <= b.startTime OR :start >= b.endTime)")
    int countConflictingBookings(@Param("room") Room room,
                                 @Param("start") LocalDateTime start,
                                 @Param("end") LocalDateTime end);
}