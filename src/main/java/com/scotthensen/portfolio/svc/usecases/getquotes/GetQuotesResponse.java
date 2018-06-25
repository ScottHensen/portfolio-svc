package com.scotthensen.portfolio.svc.usecases.getquotes;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException;

import com.scotthensen.portfolio.svc.quote.Quote;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuotesResponse 
{
	private List<Quote> quotes; 
	private HttpClientErrorException httpException;
}
