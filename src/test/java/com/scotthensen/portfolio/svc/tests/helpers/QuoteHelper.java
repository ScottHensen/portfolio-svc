package com.scotthensen.portfolio.svc.tests.helpers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.scotthensen.portfolio.svc.quote.Quote;


public class QuoteHelper {

	private String teslaSym     = "TSLA";
	private BigDecimal teslaBid = new BigDecimal("100.50");
	private BigDecimal teslaAsk = new BigDecimal("101.50");
	
	private String     samSym   = "SAM";
    private	BigDecimal samBid   = new BigDecimal("200.50");
	private BigDecimal samAsk   = new BigDecimal("201.50");

	public Quote getQuote1() 
	{
		return new Quote(null, teslaSym, teslaBid, teslaAsk);
	}
	
	public Quote getQuote2() 
	{
		return new Quote(null, samSym, samBid, samAsk);
	}
	public List<Quote> getQuotes()
	{
		List<Quote> quotes = new ArrayList<>();
		quotes.add(new Quote(null, teslaSym, teslaBid, teslaAsk));
		quotes.add(new Quote(null, samSym, samBid, samAsk));
		return quotes;
	}
}
