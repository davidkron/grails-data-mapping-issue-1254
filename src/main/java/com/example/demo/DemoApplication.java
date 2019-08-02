package com.example.demo;

import com.example.demo.services.RequestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private RequestService requestService;
    private EntityManager entityManager;

    public DemoApplication(RequestService requestService, EntityManager entityManager) {
        this.requestService = requestService;
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        requestService.initRequests();
        requestService.listRequests();
    }
}
