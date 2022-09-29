package com.deloitte.divya.pancard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.divya.pancard.entity.PancardEntity;
import com.deloitte.divya.pancard.repo.PancardRepo;

@Service
public class PancardServiceImpl implements PancardService {
	
	@Autowired
    PancardRepo repo;

	@Override
	public void addPanCardDetails(PancardEntity panCardDetails) {
		
		repo.save(panCardDetails);
	}

	@Override
	public List<PancardEntity> getAllPanCardDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public PancardEntity getPanCardDetailsById(String pancardNumber) {
		// TODO Auto-generated method stub
		return repo.getByPanNumber(pancardNumber);
	}

}
