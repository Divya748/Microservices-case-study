package com.deloitte.divya.bank.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.deloitte.divya.bank.dto.PancardEntity;
import com.deloitte.divya.bank.repo.PanProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class PanServiceDelegate {

	@Autowired
	PanProxy proxy;
	
	
	@CircuitBreaker(name = "Pancard-service",fallbackMethod = "pancardServiceFallBack")
	public PancardEntity getPanDetailsFromProxy(String adharNumber) {
		PancardEntity panDetails = proxy.getPanCardDetailsById(adharNumber);
		return panDetails;
	}
	
	public PancardEntity pancardServiceFallBack(String adharNumber, Exception e) {
		System.out.println("Pancard service is down!!!.... fallback method is enabled..");
		PancardEntity details = new PancardEntity();
		return details;
	}
}
