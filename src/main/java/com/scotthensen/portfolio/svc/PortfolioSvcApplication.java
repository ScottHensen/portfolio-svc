package com.scotthensen.portfolio.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scotthensen.portfolio.svc.PortfolioSvcApplication;

@SpringBootApplication
//@EnableJpaAuditing  ...create an auditModel
public class PortfolioSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioSvcApplication.class, args);
	}
}
