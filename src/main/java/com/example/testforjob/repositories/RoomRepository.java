package com.example.testforjob.repositories;

import com.example.testforjob.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <Room,Long> {
    @Query("SELECT DISTINCT r FROM Room r " +
            "LEFT JOIN r.bookings b " +
            "WHERE r.capacity >= :minCapacity AND " +
            "(b is null OR :end <= b.startTime OR :start >= b.endTime) AND " +
            "(r.coworking is null OR r.coworking.coworkingId = :coworkingId)")
    List<Room> findAvailableRooms(@Param("minCapacity") int minCapacity,
                                  @Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end,
                                  @Param("coworkingId") Long coworkingId);


}

