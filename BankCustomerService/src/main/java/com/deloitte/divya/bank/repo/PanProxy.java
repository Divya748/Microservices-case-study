package com.deloitte.divya.bank.repo;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.divya.bank.dto.PancardEntity;

@FeignClient(name = "Pancard-service")
public interface PanProxy {

	@GetMapping("/pancardservice/pancard/getPanCardDetailsById/{panNumber}")
	PancardEntity getPanCardDetailsById(@PathVariable("panNumber") String panNumber);
}
