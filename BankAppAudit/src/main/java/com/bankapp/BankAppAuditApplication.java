package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 
 * @author Jay Singh
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BankAppAuditApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppAuditApplication.class, args);
	}

}
