package com.scotthensen.portfolio.svc.tests.integ.quote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.tests.helpers.QuoteHelper;

@DataJpaTest
@RunWith(SpringRunner.class)
public class QuoteJpaTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void givenValidQuote_whenJpaPersist_thenPersistsQuote() 
	{
		QuoteHelper helper = new QuoteHelper();
		Quote q1 = helper.getQuote1();

		Quote q = this.testEntityManager.persistAndFlush(q1);
		
		Assertions.assertThat(q.getSymbol()).isEqualTo(q1.getSymbol());
		Assertions.assertThat(q.getBid()).isEqualTo(q1.getBid());
		Assertions.assertThat(q.getAsk()).isEqualTo(q1.getAsk());
	}
}