package com.scotthensen.portfolio.svc.quote;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Quote 
{
	@Id
	private String symbol;
	private BigDecimal bid;
	private BigDecimal ask;
}
