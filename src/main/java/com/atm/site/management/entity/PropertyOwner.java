package com.atm.site.management.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "property_owner")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "contact_details", nullable = false)
	String contactDetails;

	@Column(name = "bank_account_info", nullable = false)
	String bankAccountInfo;

	@OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL)
	List<AtmSite> atmSites = new ArrayList<>();

}
