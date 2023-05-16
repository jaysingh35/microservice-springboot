package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Accounts;
import com.bankapp.model.Audit;
import com.bankapp.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	// createAccount happens upon createCustomer
	public void createAccount(int acctID, int balance, String acctStatus) {
		Accounts acct = new Accounts(acctID, balance, acctStatus);
		accountService.createAccount(acct);
	}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.depositAmount(acctID, amount);
		Audit audit = new Audit(acctID, "Deposited", "Success", initBal, initBal + amount);
		accountService.captureAudit(audit);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Audit logger = new Audit(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		accountService.captureAudit(logger);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Audit senderAudit = new Audit(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		accountService.captureAudit(senderAudit);
		Audit auditReceiver = new Audit(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		accountService.captureAudit(auditReceiver);

	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable Integer acctID) {
		accountService.deleteAccount(acctID);
		accountService.deleteAudit(toString().valueOf(acctID));
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		Accounts result= accountService.getAccountInfo(acctID);
		Audit audit=accountService.fetchAudit(toString().valueOf(acctID));
		System.out.println("Audit>>>>>"+audit);
		return result;
	}

}
