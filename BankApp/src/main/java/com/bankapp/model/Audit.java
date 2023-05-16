package com.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="AUDIT")
@Data
public class Audit {
 
	@Id
	private Integer acctID;
	
	@Column(name="TRANSACTION_TYPE")
	private String transacType;
	
	@Column(name="TRANSACTION_STATUS")
	private String transacStatus;
	
	@Column(name="INITIAL_BALANCE")
	private int initBal;
	
	@Column(name="FINAL_BALANCE")
	private Integer finalBal;

	public Audit() {

	}

	public Audit(int acctID, String transacType, String transacStatus, int initBal, int finalBal) {
		super();
		this.acctID = acctID;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}


}
