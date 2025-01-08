package com.atm.site.management.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyOwnerDto {

	Long id;

	String name;

	String contactDetails;

	String bankAccountInfo;

}
