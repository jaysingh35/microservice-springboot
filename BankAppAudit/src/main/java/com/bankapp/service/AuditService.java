package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.AuditRepository;
import com.bankapp.model.Audit;

@Service
public class AuditService {
	@Autowired
	AuditRepository loggerRepository;

	public void addAudit(Audit logger) {
		loggerRepository.save(logger);
	}

	public Audit fetchAudit(int acctID) {
		return loggerRepository.findById(acctID).orElse(null);
	}

	public void deleteAudit(int acctID) {
		loggerRepository.deleteById(acctID);
	}
}
