package com.scotthensen.portfolio.svc.tests.unit.portfolio;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.scotthensen.portfolio.svc.portfolio.Portfolio;
import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.tests.helpers.QuoteHelper;

public class PortfolioTest {

	@Test
	public void givenValidArgs_whenAllArgConstructorCalled_thenPortfolioIsConstructed() {
		
		// Given valid arguments
		Long   portfolioId   = 1L;
		String portfolioName = "test portfolio";
		QuoteHelper helper   = new QuoteHelper();
		List<Quote> quotes   = helper.getQuotes();
		
		// When AllArgsConstructor executes
		Portfolio p = new Portfolio(portfolioId, portfolioName, quotes);
		
		// Then a portfolio with Tesla and Sam Adams is constructed	
		Assertions.assertThat(p.getId()).isEqualTo(portfolioId);
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
		Assertions.assertThat(p.getQuotes()).containsAll(quotes);
	}

}
