package com.deloitte.divya.bank.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class PancardEntity {

	
	private String pancardNumber;
	
	private String firstName;

	private String lastName;

	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	private Date dateOfBirth;
}
