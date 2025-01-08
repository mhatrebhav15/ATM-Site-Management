package com.atm.site.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.site.management.dto.LeaseAgreementDto;
import com.atm.site.management.service.LeaseAgreementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lease-agreements")
@RequiredArgsConstructor
public class LeaseAgreementController {

    private final LeaseAgreementService leaseAgreementService;

    @PostMapping
    public ResponseEntity<LeaseAgreementDto> createLeaseAgreement(@RequestBody LeaseAgreementDto leaseAgreementDto) {
        LeaseAgreementDto createdAgreement = leaseAgreementService.createLeaseAgreement(leaseAgreementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAgreement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaseAgreementDto> getLeaseAgreement(@PathVariable Long id) {
        LeaseAgreementDto agreement = leaseAgreementService.getLeaseAgreementById(id);
        return ResponseEntity.ok(agreement);
    }

    @GetMapping
    public ResponseEntity<List<LeaseAgreementDto>> getAllLeaseAgreements() {
        List<LeaseAgreementDto> agreements = leaseAgreementService.getAllLeaseAgreements();
        return ResponseEntity.ok(agreements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaseAgreementDto> updateLeaseAgreement(@PathVariable Long id, @RequestBody LeaseAgreementDto leaseAgreementDto) {
        LeaseAgreementDto updatedAgreement = leaseAgreementService.updateLeaseAgreement(id, leaseAgreementDto);
        return ResponseEntity.ok(updatedAgreement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaseAgreement(@PathVariable Long id) {
        leaseAgreementService.deleteLeaseAgreement(id);
        return ResponseEntity.noContent().build();
    }
}
