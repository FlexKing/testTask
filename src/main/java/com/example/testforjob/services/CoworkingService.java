package com.example.testforjob.services;

import com.example.testforjob.entities.Coworking;
import com.example.testforjob.repositories.CoworkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoworkingService {
    @Autowired
    private CoworkingRepository coworkingRepository;

    public List<Coworking> getAllCoworkings() {
        return coworkingRepository.findAll();
    }

    public Coworking getCoworkingById(Long id) {
        return coworkingRepository.findById(id).orElse(null);
    }
    public Coworking saveCoworking (Coworking coworking){
      return  coworkingRepository.save(coworking);
    }
}
