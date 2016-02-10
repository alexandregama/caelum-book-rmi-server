package br.com.caelum.book.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockBookService extends UnicastRemoteObject implements StockBook {

	private static final long serialVersionUID = 7246981577151514299L;
	
	private BooksDao dao = new BooksDao();
	
	public StockBookService() throws RemoteException {
		super();
	}

	@Override
	public void removeByCode(String code) throws RemoteException {
		System.out.println("******* SERVER - Removing book from code " + code + " ******* SERVER");
		dao.removeByCode(code);
	}

	@Override
	public Book findBy(String code) throws RemoteException {
		System.out.println("******* SERVER - Finding book from code " + code + " ******* SERVER");
		Book book = dao.findBy(code);
		
		return book;
	}

}
