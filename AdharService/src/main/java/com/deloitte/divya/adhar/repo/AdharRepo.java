package com.deloitte.divya.adhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.divya.adhar.entity.AdharDetails;

@Repository
public interface AdharRepo extends JpaRepository<AdharDetails, String> {

	@Query(value="select adharDetails from AdharDetails adharDetails where adharDetails.adharNumber=?1")
	AdharDetails getDetailsById(String adharNumber);

}
