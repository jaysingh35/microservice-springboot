package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Audit;
import com.bankapp.service.AuditService;

@RestController
public class AuditController {
	@Autowired
	private AuditService auditService;

	@PostMapping(path = "/capturAudit")
	public void capturAudit(Audit audit) {
		auditService.addAudit(audit);
	}

	@GetMapping("/fetchAudit/{accountId}")
	public Audit fetchAudit(@PathVariable("accountId") int accountId) {
		return auditService.fetchAudit(accountId);
	}

	@DeleteMapping("/deleteAudit/{accountId}")
	public void deleteAudit(@PathVariable("accountId")  int accountId) {
		auditService.deleteAudit(accountId);
	}
}
