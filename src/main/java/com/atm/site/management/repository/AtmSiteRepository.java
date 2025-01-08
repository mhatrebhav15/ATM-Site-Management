package com.atm.site.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.site.management.entity.AtmSite;

@Repository
public interface AtmSiteRepository extends JpaRepository<AtmSite, Long> {

	List<AtmSite> findByStatus(String status);

	List<AtmSite> findByPropertyOwnerId(Long propertyOwnerId);

}
