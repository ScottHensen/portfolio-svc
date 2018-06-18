package com.scotthensen.portfolio.svc.tests.integ.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.portfolio.Portfolio;
import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.tests.helpers.QuoteHelper;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PortfolioJpaTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void givenValidPortfolio_whenJpaPersist_thenPortfolioPersists() 
	{
		String portfolioName = "Test Porfolio";
		QuoteHelper helper   = new QuoteHelper();
		Quote  q1 = this.testEntityManager.persist(helper.getQuote1());
		Quote  q2 = this.testEntityManager.persist(helper.getQuote2());
		List<Quote> quotes   = new ArrayList<Quote>();
		quotes.add(q1);
		quotes.add(q2);

		Portfolio p  = this.testEntityManager.persistAndFlush(new Portfolio(null,portfolioName,quotes));
		 
		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
		Assertions.assertThat(p.getQuotes()).containsAll(quotes);
	}
}