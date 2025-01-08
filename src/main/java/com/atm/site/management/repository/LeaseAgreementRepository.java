package com.atm.site.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atm.site.management.entity.LeaseAgreement;

@Repository
public interface LeaseAgreementRepository extends JpaRepository<LeaseAgreement, Long> {

	List<LeaseAgreement> findByAtmSiteId(Long atmSiteId);

}
