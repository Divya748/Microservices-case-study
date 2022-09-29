package com.deloitte.divya.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import com.deloitte.divya.bank.dto.AdharDetails;
import com.deloitte.divya.bank.dto.PancardEntity;
import com.deloitte.divya.bank.entity.Customer;
import com.deloitte.divya.bank.exception.CustomerIdNotFoundException;

import com.deloitte.divya.bank.repo.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	AdharServiceDelegate delegate;
	
	//@Autowired
	//PanProxy proxy;
	
	@Autowired
	PanServiceDelegate panDelegate;
	
	@Override
	public Customer addCustomerDetails(Customer customer) {
		if(customer.getAdharNumber() == null) 
			customer.setAdharComments("adhar-number is empty");
		else {
				kycVerify(customer);	
		}
		if(customer.getPancardNumber() == null) 
			customer.setPanComments("panCard-number is empty");
		
		else {
			verifyPan(customer);
		}
		
		repo.save(customer);
		return customer;
		}
	

	@Override
	public List<Customer> getAllCustomerDetails() {
		return repo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerDetailsById(int customerId) {
		// TODO Auto-generated method stub
		return repo.findById(customerId);
	}
	
	

	@SuppressWarnings("unused")
	public void kycVerify(Customer customer) {
//		Optional<Customer> customerDetails = getCustomerDetailsById(customerId);
//		//Customer details = customerDetails.get();
//		if(customerDetails == null) {
//			throw new CustomerIdNotFoundException();
//		}
		
		AdharDetails adharDetails = (AdharDetails) delegate.getAdharDetailsFromProxy(customer.getAdharNumber());
		//AdharDetails adharDetails = proxy.getAdharDetailsById(adharNumber);
		System.out.println(adharDetails);
		//AdharDetails actuAdharDetails = adharDetails.get();
		//Customer actualCustomer = customerDetails.get();
		//boolean val =adharNumber.equals(adharDetails.getAdharNumber());
		//System.out.println(val);
	
		if(adharDetails != null) {
		if(customer.getAdharNumber().equals(adharDetails.getAdharNumber())) {
			customer.setAdharComments("approved adhar");
		}}
		else {
			customer.setAdharComments("rejected adhar.. apply for adhar");
			/*
			 * if(actualCustomer.getAdharNumber()==null)
			 * actualCustomer.setAdharNumber(adharDetails.getAdharNumber());
			 * actualCustomer.setComments("added & approved");
			 */		}
		}

	public void verifyPan(Customer customer) {
		
		
		PancardEntity panDetails = (PancardEntity) panDelegate.getPanDetailsFromProxy(customer.getPancardNumber());
		//PancardEntity panDetails = proxy.getPanCardDetailsById(pancardNumber);
		System.out.println(panDetails);
		
		if(panDetails != null) {
		if(customer.getPancardNumber().equals(panDetails.getPancardNumber())) {
			customer.setPanComments("approved pan");
		}}
		else {
			customer.setPanComments("rejected pan.. apply for pan");
			
		}
	
	}


	@Override
	public void updateAdhar(int id, String adharNumber) {
		Optional<Customer> customerDetails = getCustomerDetailsById(id);
		if(customerDetails == null) {
			throw new CustomerIdNotFoundException();
		}
		Customer actualCustomer = customerDetails.get();
		actualCustomer.setAdharNumber(adharNumber);
		kycVerify(actualCustomer);
		repo.save(actualCustomer);
	}


	@Override
	public void updatePan(int id, String panNumber) {
		// TODO Auto-generated method stub
		Optional<Customer> customerDetails = getCustomerDetailsById(id);
		if(customerDetails == null) {
			throw new CustomerIdNotFoundException();
		}
		Customer actualCustomer = customerDetails.get();
		actualCustomer.setPancardNumber(panNumber);
		verifyPan(actualCustomer);
		repo.save(actualCustomer);
	}



}
