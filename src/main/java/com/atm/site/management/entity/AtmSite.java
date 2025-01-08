package com.atm.site.management.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "atm_site")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtmSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

    @Column(name = "site_code", nullable = false, unique = true)
	String siteCode;
	
    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "status", nullable = false)
    String status;

    @Column(name = "installation_date", nullable = false)
    LocalDate installationDate;

	@ManyToOne
	@JoinColumn(name = "property_owner_id", nullable = false)
	PropertyOwner propertyOwner;

}
