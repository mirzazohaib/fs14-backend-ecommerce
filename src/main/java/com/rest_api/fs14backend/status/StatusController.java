package com.rest_api.fs14backend.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping("/")
    public List<Status> findAll(){
        return statusService.findAll();
    }

    @PostMapping("/")
    public Status createOne(@RequestBody Status status) {
        return statusService.createOne(status);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        statusService.deleteById(id);
    }
}
