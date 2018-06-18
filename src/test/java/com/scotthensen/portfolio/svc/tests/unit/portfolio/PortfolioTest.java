package com.scotthensen.portfolio.svc.tests.unit.portfolio;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.scotthensen.portfolio.svc.portfolio.Portfolio;

public class PortfolioTest {

	@Test
	public void givenValidArgs_whenAllArgConstructorCalled_thenPortfolioIsConstructed() {
		
		// Given valid arguments
		Long   portfolioId   = 1L;
		String portfolioName = "test portfolio";
		
		// When AllArgsConstructor executes
		Portfolio p = new Portfolio(portfolioId, portfolioName);
		
		// Then a portfolio with Tesla and Sam Adams is constructed	
		Assertions.assertThat(p.getId()).isEqualTo(portfolioId);
		Assertions.assertThat(p.getPortfolioName()).isEqualTo(portfolioName);
	}

}
