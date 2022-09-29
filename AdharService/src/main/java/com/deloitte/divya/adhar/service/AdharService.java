package com.deloitte.divya.adhar.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.divya.adhar.entity.AdharDetails;

public interface AdharService {

	void addAdharDetails(AdharDetails adharDetails);

	List<AdharDetails> getAllAdharDetails();

	AdharDetails getAdharDetailsById(String adharNumber);

}
