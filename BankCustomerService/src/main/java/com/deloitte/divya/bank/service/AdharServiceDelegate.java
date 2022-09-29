package com.deloitte.divya.bank.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deloitte.divya.bank.dto.AdharDetails;
import com.deloitte.divya.bank.repo.AdharProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class AdharServiceDelegate {

	@Autowired
	AdharProxy proxy;
	
	@CircuitBreaker(name = "adhar-service",fallbackMethod = "adharServiceFallBack")
	public AdharDetails getAdharDetailsFromProxy(String adharNumber) {
		AdharDetails adharDetails = proxy.getAdharDetailsById(adharNumber);
		return adharDetails;
	}
	
	public AdharDetails adharServiceFallBack(String adharNumber, Exception e) {
		System.out.println("adhar service is down!!!.... fallback method is enabled..");
		AdharDetails adharDetails = new AdharDetails();
		return adharDetails;
	}
}
