package br.com.caelum.book.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.book.observer.ClientObserver;

public class StockBookService extends UnicastRemoteObject implements StockBook {

	private static final long serialVersionUID = 7246981577151514299L;
	
	private BooksDao dao = new BooksDao();
	
	private List<ClientObserver> observers = new ArrayList<>();
	
	public StockBookService() throws RemoteException {
		super();
	}
	
	@Override
	public void removeByCode(String code) throws RemoteException {
		System.out.println("******* SERVER - Removing book from code " + code + " ******* SERVER");
		dao.removeByCode(code);
		
		System.out.println("******* SERVER - Notifing Client Observers -  ******* SERVER");
		for (ClientObserver observer : observers) {
			observer.notifyClient();
		}
	}

	@Override
	public Book findBy(String code) throws RemoteException {
		System.out.println("******* SERVER - Finding book from code " + code + " ******* SERVER");
		Book book = dao.findBy(code);
		
		return book;
	}

	@Override
	public void addObservers(ClientObserver observer) throws RemoteException {
		System.out.println("******* SERVER - Adding a new Observer ******* SERVER");
		this.observers.add(observer);
	}

}
