package com.deloitte.divya.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.deloitte.divya.bank.repo.AdharProxy;
import com.deloitte.divya.bank.repo.PanProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = {AdharProxy.class,PanProxy.class })
public class BankCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomerServiceApplication.class, args);
	}

}
