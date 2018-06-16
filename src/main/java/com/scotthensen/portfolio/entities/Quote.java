package com.scotthensen.portfolio.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
	
		@Id
		@GeneratedValue
		private Long id;
		private String symbol;
		private BigDecimal bid;
		private BigDecimal ask;
}
