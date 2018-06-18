package com.scotthensen.portfolio.svc.usecases

import com.scotthensen.portfolio.svc.quote.Quote
import com.scotthensen.portfolio.svc.usecases.getquote.GetQuoteRequestModel

import spock.lang.Specification

class GetQuote extends Specification {

	def "just a test"() {
		expect:
		1 + 1 == 2
	}
	def "given a symbol exists in repository, when a quote is requested, then a quote is returned"() {
//		given:
//		String symbol = "TSLA"
//		GetQuoteRequestModel req = new GetQuoteRequestModel(symbol)
//		
//		when:
//		Quote quote = svc.getQuoteBySymbol(symbol);
//		then:
	}
	def "given a symbol does not exist in repository, when a quote is requested, then an error is returned"() {
		
	}
}
