package com.bankapp.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankapp.dao.AccountsRepository;
import com.bankapp.model.Accounts;
import com.bankapp.model.Audit;

@Service
public class AccountService {
	
	public static final String AUDIT_SERVICE_URL = "http://BANKAPP-AUDIT-MICROSERVICE";
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	private AccountsRepository accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) {
		return accountRepository.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return accountRepository.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) {
		accountRepository.saveBalanceByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);

		
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

	public ResponseEntity<String> captureAudit(Audit audit) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Audit> httpEntity = new HttpEntity<>(audit, headers);
		return restTemplate.postForEntity(AUDIT_SERVICE_URL+"/capturAudit", httpEntity, String.class);
	}
	
	public Audit fetchAudit(String accountId) {
		return restTemplate.getForObject(AUDIT_SERVICE_URL+"/fetchAudit/"+accountId, Audit.class);
	}
	
	public void deleteAudit(String accountId) {
		 restTemplate.delete(AUDIT_SERVICE_URL+"/deleteAudit/"+accountId);

	}

}
