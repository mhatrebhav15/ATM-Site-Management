package com.atm.site.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.site.management.dto.PropertyOwnerDto;
import com.atm.site.management.entity.PropertyOwner;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropertyOwnerService {

    private final PropertyOwnerRepository propertyOwnerRepository;

    public PropertyOwnerDto createPropertyOwner(PropertyOwnerDto propertyOwnerDto) {
        PropertyOwner propertyOwner = new PropertyOwner();
        propertyOwner.setName(propertyOwnerDto.getName());
        propertyOwner.setContactDetails(propertyOwnerDto.getContactDetails());
        propertyOwner.setBankAccountInfo(propertyOwnerDto.getBankAccountInfo());

        PropertyOwner savedOwner = propertyOwnerRepository.save(propertyOwner);
        return mapToDto(savedOwner);
    }

    public PropertyOwnerDto getPropertyOwnerById(Long id) {
        PropertyOwner propertyOwner = propertyOwnerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property Owner not found"));
        return mapToDto(propertyOwner);
    }

    public List<PropertyOwnerDto> getAllPropertyOwners() {
        return propertyOwnerRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public PropertyOwnerDto updatePropertyOwner(Long id, PropertyOwnerDto propertyOwnerDto) {
        PropertyOwner propertyOwner = propertyOwnerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property Owner not found"));

        propertyOwner.setName(propertyOwnerDto.getName());
        propertyOwner.setContactDetails(propertyOwnerDto.getContactDetails());
        propertyOwner.setBankAccountInfo(propertyOwnerDto.getBankAccountInfo());

        PropertyOwner updatedOwner = propertyOwnerRepository.save(propertyOwner);
        return mapToDto(updatedOwner);
    }

    public void deletePropertyOwner(Long id) {
        if (!propertyOwnerRepository.existsById(id)) {
            throw new EntityNotFoundException("Property Owner not found");
        }
        propertyOwnerRepository.deleteById(id);
    }

    private PropertyOwnerDto mapToDto(PropertyOwner propertyOwner) {
        return new PropertyOwnerDto(
                propertyOwner.getId(),
                propertyOwner.getName(),
                propertyOwner.getContactDetails(),
                propertyOwner.getBankAccountInfo()
        );
    }
}
