package com.scotthensen.portfolio.svc.portfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio 
{
	@Id
	@GeneratedValue
	private Long id;
	private String portfolioName;
//	private Collection<Quote> quotes = new HashSet<>();
}

//@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "portfolio")
//@OrderBy("symbol")
//@JoinColumn(name="symbol")
  