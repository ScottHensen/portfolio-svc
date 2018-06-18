package com.scotthensen.portfolio.svc.tests.integ.quote;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.quote.QuoteRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class QuoteRepositoryTest 
{
	@Autowired
	private QuoteRepository repository;
	
	@Test
	public void givenValidQuote_whenSave_thenQuotePersists()
	{
		String teslaSym     = "TSLA";
		BigDecimal teslaBid = new BigDecimal("100.50");
		BigDecimal teslaAsk = new BigDecimal("101.50");
		
		Quote q = repository.save(new Quote(teslaSym, teslaBid, teslaAsk));

		Assertions.assertThat(q.getSymbol()).isEqualTo(teslaSym);
		Assertions.assertThat(q.getAsk()).isEqualTo(teslaAsk);
		Assertions.assertThat(q.getBid()).isEqualTo(teslaBid);
	}
}
