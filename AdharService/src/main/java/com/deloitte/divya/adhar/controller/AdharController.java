package com.deloitte.divya.adhar.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.divya.adhar.entity.AdharDetails;
import com.deloitte.divya.adhar.service.AdharService;


@RestController
@RequestMapping("/adhar")
public class AdharController {
	
	@Autowired
	AdharService service;

	@PostMapping("/addadhardetails")
	public ResponseEntity<String> addAdharDetails(@RequestBody AdharDetails adharDetails) {
		service.addAdharDetails(adharDetails);
		return new ResponseEntity<String>("adhar details added successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getalladhardetails")
	public ResponseEntity<List<AdharDetails>> getAllAdharDetails() {
		List<AdharDetails> details = service.getAllAdharDetails();
		return new ResponseEntity<List<AdharDetails>>(details, HttpStatus.OK);
	}
	
	@GetMapping("/getAdharDetailsById/{adharNumber}")
	public ResponseEntity<AdharDetails> getAdharDetailsById(@PathVariable("adharNumber") String adharNumber) {
		AdharDetails adharDetails = service.getAdharDetailsById(adharNumber);
		return new ResponseEntity<AdharDetails>(adharDetails, HttpStatus.OK);
	}

	
}
