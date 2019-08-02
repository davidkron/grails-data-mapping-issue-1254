package com.example.demo.services;

import com.example.demo.entities.MultiRequest;
import com.example.demo.entities.PartialRequest;
import com.example.demo.repositories.MultiRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {

    private MultiRequestRepository multiRequestRepository;

    public RequestService(MultiRequestRepository multiRequestRepository) {
        this.multiRequestRepository = multiRequestRepository;
    }

    @Transactional
    public void initRequests() {
        MultiRequest multiRequest = new MultiRequest();
        multiRequest.addPartialRequest(new PartialRequest());
        multiRequest.addPartialRequest(new PartialRequest());
        multiRequestRepository.save(multiRequest);
        System.out.println(multiRequest);
    }

    @Transactional
    public void listRequests() {
        MultiRequest multiRequest = multiRequestRepository.findAll().get(0);
        System.out.println(multiRequest);
        multiRequest.getPartialRequests().forEach(System.out::println);
    }
}
