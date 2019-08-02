package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PartialRequest extends Request {

    @ManyToOne
    private MultiRequest multiRequest;

    public MultiRequest getMultiRequest() {
        return multiRequest;
    }

    void setMultiRequest(MultiRequest multiRequest) {
        this.multiRequest = multiRequest;
    }
}
