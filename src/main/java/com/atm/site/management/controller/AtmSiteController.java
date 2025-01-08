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

import com.atm.site.management.dto.AtmSiteDto;
import com.atm.site.management.service.AtmSiteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/atm-sites")
@RequiredArgsConstructor
public class AtmSiteController {

    private final AtmSiteService atmSiteService;

    @PostMapping
    public ResponseEntity<AtmSiteDto> createAtmSite(@RequestBody AtmSiteDto atmSiteDto) {
        AtmSiteDto createdAtmSite = atmSiteService.createAtmSite(atmSiteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAtmSite);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtmSiteDto> getAtmSite(@PathVariable Long id) {
        AtmSiteDto atmSite = atmSiteService.getAtmSiteById(id);
        return ResponseEntity.ok(atmSite);
    }

    @GetMapping
    public ResponseEntity<List<AtmSiteDto>> getAllAtmSites() {
        List<AtmSiteDto> atmSites = atmSiteService.getAllAtmSites();
        return ResponseEntity.ok(atmSites);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtmSiteDto> updateAtmSite(@PathVariable Long id, @RequestBody AtmSiteDto atmSiteDto) {
        AtmSiteDto updatedAtmSite = atmSiteService.updateAtmSite(id, atmSiteDto);
        return ResponseEntity.ok(updatedAtmSite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtmSite(@PathVariable Long id) {
        atmSiteService.deleteAtmSite(id);
        return ResponseEntity.noContent().build();
    }
}
