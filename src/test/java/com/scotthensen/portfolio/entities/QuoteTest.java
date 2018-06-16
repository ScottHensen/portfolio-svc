package com.scotthensen.portfolio.entities;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class QuoteTest {

	@Test
	public void shouldConstructQuote() {
	
		// Given an id, symbol, bid and ask
		Long	   teslaId  = 1L;
		String     teslaSym = "TSLA";
		BigDecimal teslaBid = new BigDecimal("100.50");
		BigDecimal teslaAsk = new BigDecimal("101.50");
//		String     teslaName       = "Tesla";
//		BigDecimal teslaOpen       = new BigDecimal("100.00");
//		BigDecimal teslaClose      = new BigDecimal("100.00");
//		BigDecimal teslaHigh       = new BigDecimal("101.50");
//		BigDecimal teslaLow        = new BigDecimal("100.00");
//		BigDecimal teslaVolume     = new BigDecimal("123456789");
//		BigDecimal teslaLastSale   = new BigDecimal("101.00");
//		BigDecimal teslaPrevClose  = new BigDecimal("100.00");
//		BigDecimal teslaChangeAmt  = new BigDecimal("1.25");
//		BigDecimal teslaChangePct  = new BigDecimal("0.0125");
//		BigDecimal teslaMktCap     = new BigDecimal("123456789");
//		BigDecimal teslaPeRatio    = new BigDecimal("12.34");
//		BigDecimal teslaWeek52High = new BigDecimal("101.50");
//		BigDecimal teslaWeek52Low  = new BigDecimal("90.25");
//		BigDecimal teslaYtdChange  = new BigDecimal("8.21");
		
		
		// When AllArgsConstructor executes
		Quote p = new Quote(teslaId, teslaSym, teslaBid, teslaAsk);
		
		// Then a quote with the given data is constructed
		Assertions.assertThat(p.getId()).isEqualTo(teslaId);
		Assertions.assertThat(p.getSymbol()).isEqualTo(teslaSym);
		Assertions.assertThat(p.getBid()).isEqualByComparingTo(teslaBid);
		Assertions.assertThat(p.getAsk()).isEqualTo(teslaAsk);
	}
}
