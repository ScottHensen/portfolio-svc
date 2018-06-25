package com.scotthensen.portfolio.svc.tests.integ

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException

import com.scotthensen.portfolio.svc.usecases.getquotes.GetQuotes
import com.scotthensen.portfolio.svc.usecases.getquotes.IexQuoteSvc
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
	def GetQuotes quotes = new IexQuoteSvc();
	@Shared
	def GetQuotesResponse quotesResponse = new GetQuotesResponse();

	def List<String> symbols = new ArrayList<>();
	
	def "Get a quote for a valid symbol"() {

		given: "a valid symbol (TSLA)"
		symbols.add("TSLA")
		GetQuotesRequest quotesRequest = new GetQuotesRequest(symbols);
		
		when: "a request for a quote is made"
		quotesResponse = quotes.getQuotes(quotesRequest);
		
		then: "the quote is returned"
		quotesResponse.getQuotes().get(0).getSymbol() == "TSLA"
	}
	def "Get a quote for an invalid symbol"() {

		given: "an invalid symbol (xxx)"
		symbols.add("xxx")
		GetQuotesRequest quotesRequest = new GetQuotesRequest(symbols);
		
		when: "a request for a quote is made"
		quotesResponse = quotes.getQuotes(quotesRequest);
		
		then: "an HttpClientErrorException (404) is returned in the response"
		quotesResponse.getHttpException().getStatusCode() == HttpStatus.NOT_FOUND
		quotesResponse.getQuotes() == null
	}
	def "Get a quote for a missing symbol"() {

		given: "a missing symbol"
		GetQuotesRequest quotesRequest = new GetQuotesRequest();
		
		when: "a request for a quote is made"
		quotesResponse = quotes.getQuotes(quotesRequest);
		
		then: "an HttpClientErrorException is returned in the response"
		quotesResponse.getHttpException().getStatusCode() == HttpStatus.BAD_REQUEST
		quotesResponse.getQuotes() == null
	}
	def "Get multiple quotes; some are valid symbols and some aren't"() {

		given: "a mix of valid and invalid symbols (TSLA, xxx, SAM)"
		symbols.add("TSLA")
		symbols.add("xxx")
		symbols.add("SAM")
		GetQuotesRequest quotesRequest = new GetQuotesRequest(symbols);

		when: "a request for a quote is made"
		quotesResponse = quotes.getQuotes(quotesRequest);
		
		then: "the quotes are returned for the valid symols (in alphabetical order)"
		quotesResponse.getQuotes().get(0).getSymbol() == "SAM"
		quotesResponse.getQuotes().get(1).getSymbol() == "TSLA"
		
	}
}
