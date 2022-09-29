package com.deloitte.divya.pancard.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.divya.pancard.entity.PancardEntity;

public interface PancardService {

	void addPanCardDetails(PancardEntity panCardDetails);

	List<PancardEntity> getAllPanCardDetails();

	PancardEntity getPanCardDetailsById(String pancardNumber);

}
