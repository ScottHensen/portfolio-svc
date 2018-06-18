package com.scotthensen.portfolio.svc.tests.integ.portfolio;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.portfolio.Portfolio;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PortfolioJpaTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void givenValidPortfolio_whenJpaPersist_thenPortfolioPersists() 
	{
		String portfolioName = "Test Porfolio";

		Portfolio p = this.testEntityManager.persistAndFlush(new Portfolio(null,portfolioName));
		
		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
	}
}