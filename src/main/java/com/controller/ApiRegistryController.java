package com.controller;

import com.entity.ApiRegistration;
import com.service.ApiRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiRegistryController {

    @Autowired
    ApiRegistrationService service;

    @PostMapping("/add/api")
    public ApiRegistration createUser(@RequestBody ApiRegistration api){
        return service.postApiDetails(api);
    }

    @GetMapping("/get/apid/{id}")
    public Optional<ApiRegistration> findOneApi(@RequestParam("id") Long apiId){
        return service.getApiDetails(apiId);
    }

    @GetMapping("/all/api")
    public List<ApiRegistration> findAll(){
        return service.getAllApiDetails();
    }

}
