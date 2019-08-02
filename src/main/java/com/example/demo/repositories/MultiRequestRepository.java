package com.example.demo.repositories;

import com.example.demo.entities.MultiRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiRequestRepository extends JpaRepository<MultiRequest, Long> {

}
