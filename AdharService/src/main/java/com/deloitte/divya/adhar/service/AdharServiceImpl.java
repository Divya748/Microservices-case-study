package com.deloitte.divya.adhar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.divya.adhar.entity.AdharDetails;
import com.deloitte.divya.adhar.repo.AdharRepo;

@Service
public class AdharServiceImpl implements AdharService{

	@Autowired
	AdharRepo repo;
	
	@Override
	public void addAdharDetails(AdharDetails adharDetails) {
		repo.save(adharDetails);
	}

	@Override
	public List<AdharDetails> getAllAdharDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public AdharDetails getAdharDetailsById(String adharNumber) {
		// TODO Auto-generated method stub
		return repo.getDetailsById(adharNumber);
	}

	
}
