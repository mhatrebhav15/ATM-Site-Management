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

import com.atm.site.management.dto.PropertyOwnerDto;
import com.atm.site.management.service.PropertyOwnerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/property-owners")
@RequiredArgsConstructor
public class PropertyOwnerController {

    private final PropertyOwnerService propertyOwnerService;

    @PostMapping
    public ResponseEntity<PropertyOwnerDto> createPropertyOwner(@RequestBody PropertyOwnerDto propertyOwnerDto) {
        PropertyOwnerDto createdOwner = propertyOwnerService.createPropertyOwner(propertyOwnerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOwner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyOwnerDto> getPropertyOwner(@PathVariable Long id) {
        PropertyOwnerDto owner = propertyOwnerService.getPropertyOwnerById(id);
        return ResponseEntity.ok(owner);
    }

    @GetMapping
    public ResponseEntity<List<PropertyOwnerDto>> getAllPropertyOwners() {
        List<PropertyOwnerDto> owners = propertyOwnerService.getAllPropertyOwners();
        return ResponseEntity.ok(owners);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyOwnerDto> updatePropertyOwner(@PathVariable Long id, @RequestBody PropertyOwnerDto propertyOwnerDto) {
        PropertyOwnerDto updatedOwner = propertyOwnerService.updatePropertyOwner(id, propertyOwnerDto);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropertyOwner(@PathVariable Long id) {
        propertyOwnerService.deletePropertyOwner(id);
        return ResponseEntity.noContent().build();
    }
}
