package com.scotthensen.portfolio.svc.usecases.getquotes;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuotesResponse 
{
	private List<StockQuote> quotes; 
}
