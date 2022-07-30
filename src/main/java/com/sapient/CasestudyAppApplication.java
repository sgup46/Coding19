package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CasestudyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasestudyAppApplication.class, args);
	}

}
