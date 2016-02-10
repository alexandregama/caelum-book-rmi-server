package br.com.caelum.book.register;

import static org.junit.Assert.assertEquals;

import java.rmi.Naming;

import org.junit.Test;

import br.com.caelum.book.service.Book;
import br.com.caelum.book.service.StockBook;

public class StockBookRmiServiceTest {

	@Test
	public void shouldRemoveABookUsingRMI() throws Exception {
		StockBook service = (StockBook) Naming.lookup("rmi://localhost:1099/stockservice");
		
		service.removeByCode("SOA");
		
		Book book = service.findBy("SOA");
		
		assertEquals(4, book.getQuantity());
	}
}
