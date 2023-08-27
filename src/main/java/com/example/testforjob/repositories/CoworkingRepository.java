package com.example.testforjob.repositories;

import com.example.testforjob.entities.Coworking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkingRepository extends JpaRepository <Coworking,Long> {

}
