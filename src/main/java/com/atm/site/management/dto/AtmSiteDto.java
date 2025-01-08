package com.atm.site.management.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtmSiteDto {

	Long id;

	String siteCode;

	String address;

	String status;

	LocalDate installationDate;

	Long propertyOwnerId;

}
