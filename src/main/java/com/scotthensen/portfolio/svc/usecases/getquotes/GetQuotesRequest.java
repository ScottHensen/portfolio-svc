package com.scotthensen.portfolio.svc.usecases.getquotes;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor //(access = AccessLevel.NONE)
@AllArgsConstructor
public class GetQuotesRequest 
{
	private List<String> symbols; 
}
