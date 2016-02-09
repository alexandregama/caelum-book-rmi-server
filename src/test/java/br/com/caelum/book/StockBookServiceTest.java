package br.com.caelum.book;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockBookServiceTest {

	@Test
	public void shouldDecreaseOneBookFromRepository() throws Exception {
		StockBookService service = new StockBookService();
		Book bookBeforeDecrease = service.findBy("SOA");
		assertEquals(5, bookBeforeDecrease.getQuantity());
		
		service.removeByCode("SOA");
		
		Book bookAfterDecrease = service.findBy("SOA");
		assertEquals(4, bookAfterDecrease.getQuantity());
	}
	
}
