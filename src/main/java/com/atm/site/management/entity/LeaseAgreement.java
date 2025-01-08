package com.atm.site.management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "lease_agreement")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaseAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	Long id;

	@Column(name = "start_date", nullable = false)
	LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	LocalDate endDate;

	@Column(name = "rent_amount", nullable = false)
	BigDecimal rentAmount;

	@OneToOne
	@JoinColumn(name = "atm_site_id", nullable = false)
	AtmSite atmSite;

}
