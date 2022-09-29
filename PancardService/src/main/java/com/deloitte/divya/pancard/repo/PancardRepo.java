package com.deloitte.divya.pancard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.divya.pancard.entity.PancardEntity;

@Repository
public interface PancardRepo extends JpaRepository<PancardEntity, String> {

	@Query(value="select pandetails from PancardEntity pandetails where pandetails.pancardNumber=?1")
	PancardEntity getByPanNumber(String pancardNumber);

}
