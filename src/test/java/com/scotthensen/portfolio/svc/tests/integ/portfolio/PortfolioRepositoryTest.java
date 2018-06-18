package com.scotthensen.portfolio.svc.tests.integ.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.portfolio.PorfolioRepository;
import com.scotthensen.portfolio.svc.portfolio.Portfolio;
import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.tests.helpers.QuoteHelper;

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
		QuoteHelper helper = new QuoteHelper();
		List<Quote> quotes = new ArrayList<Quote>();
		quotes.add(helper.getQuote1());
		quotes.add(helper.getQuote2());

		Portfolio p = repository.save(new Portfolio(null, portfolioName, quotes));

		Assertions.assertThat(p.getId()).isNotNull();
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
		Assertions.assertThat(p.getQuotes().containsAll(quotes));
	}
}
