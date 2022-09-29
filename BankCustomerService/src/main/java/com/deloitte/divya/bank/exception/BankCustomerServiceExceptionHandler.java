package com.deloitte.divya.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankCustomerServiceExceptionHandler {

	@ExceptionHandler(value = CustomerIdNotFoundException.class)
    public ResponseEntity<Object> exception(CustomerIdNotFoundException ex){
        return new ResponseEntity<Object>("Customer Details are not present by the given id.. Please provide valid customerid", HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(value = AdharNotFoundException.class)
    public ResponseEntity<Object> adharException(AdharNotFoundException ex){
        return new ResponseEntity<Object>("Adhar details are not found.. Please provide valid adhar number", HttpStatus.NOT_FOUND);
    }
	
	
}
