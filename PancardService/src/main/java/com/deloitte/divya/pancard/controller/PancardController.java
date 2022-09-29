package com.deloitte.divya.pancard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.divya.pancard.entity.PancardEntity;
import com.deloitte.divya.pancard.service.PancardService;

@RestController
@RequestMapping("/pancard")
public class PancardController {

	@Autowired
	PancardService service;
	
	PancardEntity entity = new PancardEntity();
	
	@PostMapping("/addpandetails")
	public ResponseEntity<String> addPanCardDetails(@RequestBody PancardEntity panCardDetails) {
		service.addPanCardDetails(panCardDetails);
		return new ResponseEntity<String>("pancard details added successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getallpancarddetails")
	public ResponseEntity<List<PancardEntity>> getAllPanCardDetails() {
		List<PancardEntity> details = service.getAllPanCardDetails();
		return new ResponseEntity<List<PancardEntity>>(details, HttpStatus.OK);
	}
	
	
	@GetMapping("/getPanCardDetailsById/{pancardNumber}")
	
	public ResponseEntity<PancardEntity> getPanCardDetailsById(@PathVariable("pancardNumber") String pancardNumber) {
		PancardEntity panDetails = service.getPanCardDetailsById(pancardNumber);
		return new ResponseEntity<PancardEntity>(panDetails, HttpStatus.OK);
	}
}
