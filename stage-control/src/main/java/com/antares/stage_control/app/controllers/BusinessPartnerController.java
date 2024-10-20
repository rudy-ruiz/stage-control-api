package com.antares.stage_control.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.antares.stage_control.app.entities.BusinessPartner;
import com.antares.stage_control.app.services.BusinessPartnerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/business-partners")
public class BusinessPartnerController {

    @Autowired
    private BusinessPartnerService service;

    // Obtener todos los Business Partners
    @GetMapping
    public List<BusinessPartner> getAllPartners() {
        return service.findAll();
    }

    // Obtener un Business Partner por ID
    @GetMapping("/{id}")
    public ResponseEntity<BusinessPartner> getPartnerById(@PathVariable Long id) {
        Optional<BusinessPartner> partner = service.findById(id);
        return partner.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo Business Partner
    @PostMapping
    public BusinessPartner createPartner(@RequestBody BusinessPartner partner) {
        return service.save(partner);
    }

    // Actualizar un Business Partner existente
    @PutMapping("/{id}")
    public ResponseEntity<BusinessPartner> updatePartner(@PathVariable Long id, @RequestBody BusinessPartner partnerDetails) {
        Optional<BusinessPartner> partner = service.findById(id);
        if (partner.isPresent()) {
            BusinessPartner existingPartner = partner.get();
            existingPartner.setCardCode(partnerDetails.getCardCode());
            existingPartner.setCardName(partnerDetails.getCardName());
            return ResponseEntity.ok(service.save(existingPartner));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un Business Partner por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id) {
        Optional<BusinessPartner> partner = service.findById(id);
        if (partner.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
