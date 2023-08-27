package com.example.testforjob.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Coworking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coworkingId;
    private String name;
    private String address;
    private String phone;

    public Coworking() {

    }
}
