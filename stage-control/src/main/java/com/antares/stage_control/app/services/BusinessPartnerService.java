package com.antares.stage_control.app.services;

import java.util.List;
import java.util.Optional;

import com.antares.stage_control.app.entities.BusinessPartner;

public interface BusinessPartnerService {

    List<BusinessPartner> findAll();
    Optional<BusinessPartner> findById(Long id);
    BusinessPartner save(BusinessPartner partner);
    void deleteById(Long id);
}
