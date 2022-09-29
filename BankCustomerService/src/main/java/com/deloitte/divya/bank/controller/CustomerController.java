package com.deloitte.divya.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.divya.bank.entity.Customer;
import com.deloitte.divya.bank.exception.CustomerIdNotFoundException;
import com.deloitte.divya.bank.service.CustomerService;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	Customer customer = new Customer();
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<String> addCustomerDetails(@RequestBody Customer customer) {
		Customer details =service.addCustomerDetails(customer);
		if(details.getAdharNumber()==null && details.getPancardNumber()==null) {
			return new ResponseEntity<String>(details.getAdharComments()+".. update your adhar as soon as possible \n"+details.getPanComments()+".. update your pancard as soon as possible",HttpStatus.OK);
		}
		else if(details.getAdharNumber()==null ) {
			return new ResponseEntity<String>(details.getAdharComments()+".. update your adhar as soon as possible", HttpStatus.OK);
		}
		else if(details.getPancardNumber()==null) {
			return new ResponseEntity<String>(details.getPanComments()+"\".. update your pancard as soon as possible", HttpStatus.OK);
		}
		
			return new ResponseEntity<String>("verified", HttpStatus.OK);
		
		}
	
	
	@GetMapping("/allcustomerdetails")
	public ResponseEntity<List<Customer>> getAllCustomerDetails() {
		List<Customer> customerDetails = service.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(customerDetails,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerDetailsById(@PathVariable("id") int customerId){
		if(customerId != customer.getCustomerId()) {
			throw new CustomerIdNotFoundException();
		}
		Optional<Customer> customerDetailsById = service.getCustomerDetailsById(customerId);		
		return new ResponseEntity<Optional<Customer>>(customerDetailsById, HttpStatus.OK);
		
	}
	
	/*
	 * @GetMapping("/kycverify/{customerid}/{adharnumber}") public
	 * ResponseEntity<String> verifyLoan(@PathVariable("customerid") int
	 * customerId,@PathVariable("adharnumber") String adharNumber) {
	 * service.kycVerify(customerId,adharNumber); return new
	 * ResponseEntity<String>("verified",HttpStatus.OK); }
	 */
	
	@PutMapping("/updateadhar/{id}/{adharNumber}")
	public ResponseEntity<String> updateAadhar(@PathVariable("id") int id,@PathVariable("adharNumber") String adharNumber){
		service.updateAdhar(id,adharNumber);
		
		return new ResponseEntity<String>("adhar updated and verified",HttpStatus.OK);
		
	}

	/*
	 * @GetMapping("/panverify/{customerid}/{pancardNumber}") public
	 * ResponseEntity<String> verifyPan(@PathVariable("customerid") int customerId,
	 * 
	 * @PathVariable("pancardNumber") String pancardNumber) {
	 * service.verifyPan(customerId, pancardNumber); return new
	 * ResponseEntity<String>("verified", HttpStatus.OK); }
	 */
	

	@PutMapping("/updatepan/{id}/{panNumber}")
	public ResponseEntity<String> updatePan(@PathVariable("id") int id,@PathVariable("panNumber") String panNumber){
		service.updatePan(id,panNumber);
		return new ResponseEntity<String>("pan updated and verified",HttpStatus.OK);
		
	}
	
	

}
