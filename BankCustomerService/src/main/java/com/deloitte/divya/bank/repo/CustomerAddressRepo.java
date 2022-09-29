package com.deloitte.divya.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.divya.bank.entity.CustomerAddress;

public interface CustomerAddressRepo extends JpaRepository<CustomerAddress, Integer>{

}
