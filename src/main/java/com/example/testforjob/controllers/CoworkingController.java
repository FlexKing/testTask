package com.example.testforjob.controllers;

import com.example.testforjob.entities.Coworking;
import com.example.testforjob.services.CoworkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coworkings")
public class CoworkingController {
    @Autowired
    private CoworkingService coworkingService;

    @GetMapping
    public ResponseEntity<List<Coworking>> getAllCoworkings() {
        List<Coworking> coworkings = coworkingService.getAllCoworkings();
        return ResponseEntity.ok(coworkings);
    }

}
