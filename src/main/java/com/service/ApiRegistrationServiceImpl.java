package com.service;

import com.entity.ApiRegistration;
import com.repository.ApiRegistrationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiRegistrationServiceImpl implements ApiRegistrationService {

    @Autowired
    ApiRegistrationRepo apiRepo;

    @Override
    public Optional<ApiRegistration> getApiDetails(Long id) {
        return apiRepo.findById(id);
    }

    @Override
    public ApiRegistration postApiDetails(ApiRegistration api) {
        return apiRepo.save(api);
    }

    @Override
    public List<ApiRegistration> getAllApiDetails() {
        return apiRepo.findAll();
    }
}
