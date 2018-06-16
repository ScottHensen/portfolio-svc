package com.scotthensen.portfolio.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PortfolioTest {

	@Test
	public void shouldConstructPortfolio() {
		
		// Given two securities (Tesla and Sam Adams)
		String teslaSym = "TSLA";
		String samSym   = "SAM";
		
		Collection<String> securityList = new ArrayList<String>();
		securityList.add(teslaSym);
		securityList.add(samSym);
		
		// When AllArgsConstructor executes
		Portfolio p = new Portfolio(securityList);
		
		// Then a portfolio with Tesla and Sam Adams is constructed
		Assertions.assertThat(p.getSymbols().containsAll(securityList));
	}

}
