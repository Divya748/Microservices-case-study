package com.deloitte.divya.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

@Table
public class CustomerAddress {

	public CustomerAddress(String houseNumber, String street, String state) {
		//super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 10)
	private String houseNumber;
	
	@Column(length = 20)
	private String street;

	@Column(length = 10)
	private String state;
   

	
}
