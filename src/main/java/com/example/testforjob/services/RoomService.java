package com.example.testforjob.services;

import com.example.testforjob.entities.Room;
import com.example.testforjob.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAvailableRooms(int minCapacity, LocalDateTime start, LocalDateTime end, Long coworkingId) {
        return roomRepository.findAvailableRooms(minCapacity, start, end, coworkingId);
    }
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Room saveRoom ( Room room){
        return  roomRepository.save(room);
    }
}
