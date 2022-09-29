package com.deloitte.divya.bank.repo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.divya.bank.dto.AdharDetails;

@FeignClient(name = "adhar-service")
public interface AdharProxy {

	@GetMapping("/adharapp/adhar/getAdharDetailsById/{adharNumber}")
	AdharDetails getAdharDetailsById(@PathVariable("adharNumber") String adharNumber);
}
