package com.antares.stage_control.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antares.stage_control.app.entities.BusinessPartner;
import com.antares.stage_control.app.repositories.BusinessPartnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessPartnerServiceImpl implements BusinessPartnerService {

    @Autowired
    private BusinessPartnerRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<BusinessPartner> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BusinessPartner> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public BusinessPartner save(BusinessPartner partner) {
        return repository.save(partner);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
