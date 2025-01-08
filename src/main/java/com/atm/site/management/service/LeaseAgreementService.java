package com.atm.site.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.site.management.dto.LeaseAgreementDto;
import com.atm.site.management.entity.AtmSite;
import com.atm.site.management.entity.LeaseAgreement;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaseAgreementService {

    private final LeaseAgreementRepository leaseAgreementRepository;
    private final AtmSiteRepository atmSiteRepository;

    public LeaseAgreementDto createLeaseAgreement(LeaseAgreementDto leaseAgreementDto) {
        AtmSite atmSite = atmSiteRepository.findById(leaseAgreementDto.getAtmSiteId())
                .orElseThrow(() -> new EntityNotFoundException("ATM Site not found"));

        LeaseAgreement leaseAgreement = new LeaseAgreement();
        leaseAgreement.setAtmSite(atmSite);
        leaseAgreement.setStartDate(leaseAgreementDto.getStartDate());
        leaseAgreement.setEndDate(leaseAgreementDto.getEndDate());
        leaseAgreement.setRentAmount(leaseAgreementDto.getRentAmount());

        LeaseAgreement savedAgreement = leaseAgreementRepository.save(leaseAgreement);
        return mapToDto(savedAgreement);
    }

    public LeaseAgreementDto getLeaseAgreementById(Long id) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lease Agreement not found"));
        return mapToDto(leaseAgreement);
    }

    public List<LeaseAgreementDto> getAllLeaseAgreements() {
        return leaseAgreementRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public LeaseAgreementDto updateLeaseAgreement(Long id, LeaseAgreementDto leaseAgreementDto) {
        LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lease Agreement not found"));

        leaseAgreement.setStartDate(leaseAgreementDto.getStartDate());
        leaseAgreement.setEndDate(leaseAgreementDto.getEndDate());
        leaseAgreement.setRentAmount(leaseAgreementDto.getRentAmount());

        LeaseAgreement updatedAgreement = leaseAgreementRepository.save(leaseAgreement);
        return mapToDto(updatedAgreement);
    }

    public void deleteLeaseAgreement(Long id) {
        if (!leaseAgreementRepository.existsById(id)) {
            throw new EntityNotFoundException("Lease Agreement not found");
        }
        leaseAgreementRepository.deleteById(id);
    }

    private LeaseAgreementDto mapToDto(LeaseAgreement leaseAgreement) {
        return new LeaseAgreementDto(
                leaseAgreement.getId(),
                leaseAgreement.getAtmSite().getId(),
                leaseAgreement.getStartDate(),
                leaseAgreement.getEndDate(),
                leaseAgreement.getRentAmount()
        );
    }
}
