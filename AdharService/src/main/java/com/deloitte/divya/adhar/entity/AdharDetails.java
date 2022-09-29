package com.deloitte.divya.adhar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class AdharDetails{

	@Id	
	private String adharNumber;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(columnDefinition = "date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-mm-yyyy")
	private Date dateOfBirth;
}
