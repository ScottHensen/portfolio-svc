package com.scotthensen.portfolio.svc.usecases.getquotes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;


class GetQuotesFromIEX implements GetQuotes {

	enum QuoteType {SINGLE, MULTIPLE}
	

	public GetQuotesResponse getQuotes(GetQuotesRequest request) 
	{
		RestTemplate      restTemplate = new RestTemplate();
		List<StockQuote>  quotes       = new ArrayList<>();
		GetQuotesResponse response     = new GetQuotesResponse();
		
		if (request.getSymbol().isEmpty()) {
			response.setQuotes(quotes);
		}
		else {
			StockQuote quote = 
						restTemplate.getForObject(
										buildStringUrl(QuoteType.SINGLE, request), 
										StockQuote.class);
			quotes.add(quote);
			response.setQuotes(quotes);
		}
		return response;
		
	}

	private String buildStringUrl(QuoteType quoteType, GetQuotesRequest request) 
	{
		String urlRoot = "https://api.iextrading.com/1.0/";
		String url = "";
		if (QuoteType.SINGLE != null) {
			url = urlRoot+"stock/"+request.getSymbol().trim()+"/quote";
		}
		return url;
	}

}
