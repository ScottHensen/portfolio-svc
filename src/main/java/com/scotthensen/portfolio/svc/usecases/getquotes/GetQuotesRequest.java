package com.scotthensen.portfolio.svc.usecases.getquotes;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuotesRequest {

//	private final List<String> quotesArg;
//	private final String quoteArg;
//	
//	@Inject 
//	public QuotesRequestModel(List<String> quotesArg) {
//		Assert.notEmpty(quotesArg, "QuotesArg must not be empty"");
//		this.quotesArg = quotesArg;
//	}
	
	public GetQuotesRequest(String symbol) {
		this.symbol = symbol;
	}
//	public GetQuotesRequest(List<String> symbols) {
//		this.symbols = symbols;
//	}
	private String symbol;
	private List<String> symbols; 
}
