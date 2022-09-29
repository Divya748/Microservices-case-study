package com.deloitte.divya.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column
	private long accountNumber;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column
	private long mobile;
	@Column(length = 20)
	private String email;
	@Column(length = 20)
	private String pancardNumber;
	@Column(length = 20)
	private String adharNumber;
	@Column(length = 50)
	private String adharComments;
	@Column(length=50)
	private String panComments;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Id")
	private CustomerAddress customerAddress;

}
