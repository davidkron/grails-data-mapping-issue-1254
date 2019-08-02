package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultiRequest extends Request {

    @OneToMany(
            mappedBy = "multiRequest",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PartialRequest> partialRequests = new ArrayList<>();

    public List<PartialRequest> getPartialRequests() {
        return partialRequests;
    }

    public void addPartialRequest(PartialRequest request) {
        partialRequests.add(request);
        request.setMultiRequest(this);
    }
}
