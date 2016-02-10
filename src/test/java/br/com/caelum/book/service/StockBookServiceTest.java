package br.com.caelum.book.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.book.service.Book;
import br.com.caelum.book.service.StockBookService;

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
