package com.scotthensen.portfolio.svc.tests.integ.quote;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scotthensen.portfolio.svc.quote.Quote;
import com.scotthensen.portfolio.svc.quote.QuoteRepository;
import com.scotthensen.portfolio.svc.tests.helpers.QuoteHelper;

@DataJpaTest
@RunWith(SpringRunner.class)
public class QuoteRepositoryTest 
{
	@Autowired
	private QuoteRepository repository;
	
	@Test
	public void givenValidQuote_whenSave_thenQuotePersists()
	{
		QuoteHelper helper = new QuoteHelper();
		Quote q1 = helper.getQuote1();
		
		Quote q = repository.save(q1);

		Assertions.assertThat(q.getSymbol()).isEqualTo(q1.getSymbol());
		Assertions.assertThat(q.getAsk()).isEqualTo(q1.getAsk());
		Assertions.assertThat(q.getBid()).isEqualTo(q1.getBid());
	}
}
