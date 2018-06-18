package com.scotthensen.portfolio.svc.tests.integ.quote;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.quote.Quote;

@DataJpaTest
@RunWith(SpringRunner.class)
public class QuoteJpaTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void givenValidQuote_whenJpaPersist_thenPersistsQuote() 
	{
		String teslaSym     = "TSLA";
		BigDecimal teslaBid = new BigDecimal("100.50");
		BigDecimal teslaAsk = new BigDecimal("101.50");
		Quote tesla = new Quote(teslaSym, teslaBid, teslaAsk);

		Quote q = this.testEntityManager.persistAndFlush(tesla);
		
		Assertions.assertThat(q.getSymbol()).isEqualTo(teslaSym);
		Assertions.assertThat(q.getBid()).isEqualTo(teslaBid);
		Assertions.assertThat(q.getAsk()).isEqualTo(teslaAsk);
	}
}