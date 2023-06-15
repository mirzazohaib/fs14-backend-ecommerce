package com.rest_api.fs14backend.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> findAll(){
        return statusRepository.findAll();
    }

    public Status createOne(Status status) {
        return statusRepository.save(status);
    }

    public void deleteById(UUID id) {
        statusRepository.deleteById(id);
    }
}
