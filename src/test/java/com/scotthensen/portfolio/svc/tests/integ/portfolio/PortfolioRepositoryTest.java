package com.scotthensen.portfolio.svc.tests.integ.portfolio;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.portfolio.PorfolioRepository;
import com.scotthensen.portfolio.svc.portfolio.Portfolio;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PortfolioRepositoryTest 
{
	@Autowired
	private PorfolioRepository repository;
	
	@Test
	public void givenValidPortfolio_whenSave_thenPortfolioPersists()
	{
		String portfolioName = "test porfolio";

		Portfolio p = repository.save(new Portfolio(null, portfolioName));

		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
	}
}
