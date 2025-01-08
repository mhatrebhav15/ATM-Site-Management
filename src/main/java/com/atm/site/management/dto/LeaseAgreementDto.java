package com.atm.site.management.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LeaseAgreementDto {

	Long id;

	Long atmSiteId;

	LocalDate startDate;

	LocalDate endDate;

	BigDecimal rentAmount;

}
