package br.com.caelum.book;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockBookService extends UnicastRemoteObject implements StockBook {

	private static final long serialVersionUID = 7246981577151514299L;
	
	private BooksDao dao = new BooksDao();
	
	protected StockBookService() throws RemoteException {
		super();
	}

	@Override
	public void removeByCode(String code) throws RemoteException {
		dao.removeByCode(code);
	}

	@Override
	public Book findBy(String code) throws RemoteException {
		Book book = dao.findBy(code);
		
		return book;
	}

}
