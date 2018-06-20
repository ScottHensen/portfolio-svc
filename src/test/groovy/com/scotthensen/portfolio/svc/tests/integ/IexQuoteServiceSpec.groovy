package com.scotthensen.portfolio.svc.tests.integ

import com.scotthensen.portfolio.svc.quote.Quote
import com.scotthensen.portfolio.svc.usecases.getquotes.StockQuote

import org.springframework.web.client.RestTemplate
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Title

@Narrative ("""The IEX Quote service is called to get a list quotes.""")
@Title('Integration test with IEX Quote service')

@Stepwise
class IexQuoteServiceSpec extends Specification {

	@Shared
	def RestTemplate restTemplate = new RestTemplate()
	
	//TODO:  This is a dumb test.  I am testing IEX's service, not mine!
	def "Getting a quote from IEX"() {
		given: "a valid symbol (TSLA)"
		String url = "https://api.iextrading.com/1.0/stock/tsla/quote"
		
		when: "when a GET request is made to IEX"
		StockQuote quote = restTemplate.getForObject(url, StockQuote.class)
		
		then: "then a valid response is returned"
		quote.symbol == 'TSLA'
	}
}
