package com.scotthensen.portfolio.svc.tests.integ

import org.springframework.beans.factory.annotation.Autowired

import com.scotthensen.portfolio.svc.usecases.getquotes.GetQuotes
import com.scotthensen.portfolio.svc.usecases.getquotes.GetQuotesFromIEX
import com.scotthensen.portfolio.svc.usecases.getquotes.GetQuotesRequest
import com.scotthensen.portfolio.svc.usecases.getquotes.GetQuotesResponse

import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Title

@Narrative(""" The IEX Quote service is called to get a list quotes.""")
@Title('Integration test with IEX Quote service')

@Stepwise
class GetQuotesSpec extends Specification {

	@Shared
	def GetQuotes quotes = new GetQuotesFromIEX();
	
	def GetQuotesResponse quotesResponse = new GetQuotesResponse();
	
	def "Get one quote for a valid symbol"() {

		given: "a valid symbol (TSLA)"
		GetQuotesRequest quotesRequest = new GetQuotesRequest("TSLA");
		
		when: "a request for a quote is made"
		quotesResponse = quotes.getQuotes(quotesRequest);
		
		then: "the quote is returned"
		quotesResponse.getQuotes().get(0).getSymbol() == "TSLA"
	}
//	def "Get one quote for an invalid symbol"() {
//
//		given: "an invalid symbol (FOOBAR)"
//		
//		when: "a request for a quote is made"
//		
//		then: "the quote is returned"
//
//	}
//	def "Get multiple quotes; some are valid symbols and some aren't"() {
//
//		given: "a mix of valid and invalid symbols (TSLA & FOOBAR)"
//		
//		when: "a request for a quote is made"
//		
//		then: "the quotes are returned for the valid symols"
//
//	}
}
