package com.atm.site.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.site.management.entity.PropertyOwner;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {

	PropertyOwner findByBankAccountInfo(String bankAccountInfo);

}
