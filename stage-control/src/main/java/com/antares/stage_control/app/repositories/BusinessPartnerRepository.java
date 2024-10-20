package com.antares.stage_control.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antares.stage_control.app.entities.BusinessPartner;

public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner,Long> {

}
