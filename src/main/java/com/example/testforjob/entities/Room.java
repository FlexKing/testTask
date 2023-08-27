package com.example.testforjob.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String name;
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coworkingId")
    private Coworking coworking;
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings = new ArrayList<>();
    public Room(long l, String s, int i, Coworking coworking) {

    }
}
