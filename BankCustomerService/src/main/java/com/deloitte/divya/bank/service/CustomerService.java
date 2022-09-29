package com.deloitte.divya.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.client.ServiceInstance;

import com.deloitte.divya.bank.entity.Customer;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

public interface CustomerService {

	Customer addCustomerDetails(Customer customer);

	List<Customer> getAllCustomerDetails();

	Optional<Customer> getCustomerDetailsById(int customerId);

	//void kycVerify(int customerId, String adharNumber);

	//void verifyPan(int customerId, String pancardNumber);

	void updateAdhar(int id, String adharNumber);

	void updatePan(int id, String panNumber);


}
