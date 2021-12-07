package com.service;

import com.entity.ApiRegistration;

import java.util.List;
import java.util.Optional;

public interface ApiRegistrationService {

    Optional<ApiRegistration> getApiDetails(Long id);
    ApiRegistration postApiDetails(ApiRegistration api);
    List<ApiRegistration> getAllApiDetails();
}
