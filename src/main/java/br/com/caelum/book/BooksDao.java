package br.com.caelum.book;

import java.util.HashMap;
import java.util.Map;

public class BooksDao {

	private static Map<String, Book> database = new HashMap<>();
	
	static {
		database.put("SOA", new Book("SOA", 5));
		database.put("TDD", new Book("TDD", 10));
		database.put("REST", new Book("REST", 12));
	}
	
	public void removeByCode(String code) {
		Book book = database.get(code);
		book.decreaseQuantity();
	}

	public Book findBy(String code) {
		return database.get(code);
	}

}
