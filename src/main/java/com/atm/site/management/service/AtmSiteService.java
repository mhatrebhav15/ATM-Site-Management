package com.atm.site.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.site.management.dto.AtmSiteDto;
import com.atm.site.management.entity.AtmSite;
import com.atm.site.management.entity.PropertyOwner;
import com.atm.site.management.repository.AtmSiteRepository;
import com.atm.site.management.repository.PropertyOwnerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtmSiteService {

    private final AtmSiteRepository atmSiteRepository;
    private final PropertyOwnerRepository propertyOwnerRepository;

    public AtmSiteDto createAtmSite(AtmSiteDto atmSiteDto) {
        PropertyOwner owner = propertyOwnerRepository.findById(atmSiteDto.getPropertyOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("Property Owner not found"));

        AtmSite atmSite = new AtmSite();
        atmSite.setSiteCode(atmSiteDto.getSiteCode());
        atmSite.setAddress(atmSiteDto.getAddress());
        atmSite.setStatus(atmSiteDto.getStatus());
        atmSite.setInstallationDate(atmSiteDto.getInstallationDate());
        atmSite.setPropertyOwner(owner);

        AtmSite savedSite = atmSiteRepository.save(atmSite);
        return mapToDto(savedSite);
    }

    public AtmSiteDto getAtmSiteById(Long id) {
        AtmSite atmSite = atmSiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ATM Site not found"));
        return mapToDto(atmSite);
    }

    public List<AtmSiteDto> getAllAtmSites() {
        return atmSiteRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public AtmSiteDto updateAtmSite(Long id, AtmSiteDto atmSiteDto) {
        AtmSite atmSite = atmSiteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ATM Site not found"));

        atmSite.setSiteCode(atmSiteDto.getSiteCode());
        atmSite.setAddress(atmSiteDto.getAddress());
        atmSite.setStatus(atmSiteDto.getStatus());
        atmSite.setInstallationDate(atmSiteDto.getInstallationDate());

        AtmSite updatedSite = atmSiteRepository.save(atmSite);
        return mapToDto(updatedSite);
    }

    public void deleteAtmSite(Long id) {
        if (!atmSiteRepository.existsById(id)) {
            throw new EntityNotFoundException("ATM Site not found");
        }
        atmSiteRepository.deleteById(id);
    }

    private AtmSiteDto mapToDto(AtmSite atmSite) {
        return new AtmSiteDto(
                atmSite.getId(),
                atmSite.getSiteCode(),
                atmSite.getAddress(),
                atmSite.getStatus(),
                atmSite.getInstallationDate(),
                atmSite.getPropertyOwner().getId()
        );
    }
}
