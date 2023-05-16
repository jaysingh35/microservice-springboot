package com.bankapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.bankapp.model.Audit;

public interface AuditRepository extends CrudRepository<Audit, Integer> {

}
