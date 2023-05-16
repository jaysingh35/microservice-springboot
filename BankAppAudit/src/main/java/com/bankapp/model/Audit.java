package com.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUDIT")
public class Audit {
 
	@Id
	private int acctID;
	
	@Column(name="TRANSACTION_TYPE")
	private String transacType;
	
	@Column(name="TRANSACTION_STATUS")
	private String transacStatus;
	
	@Column(name="INITIAL_BALANCE")
	private int initBal;
	
	@Column(name="FINAL_BALANCE")
	private int finalBal;

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

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public String getTransacStatus() {
		return transacStatus;
	}

	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}

	public int getInitBal() {
		return initBal;
	}

	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}

	public int getFinalBal() {
		return finalBal;
	}

	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}

}
