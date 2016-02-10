package br.com.caelum.book.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockBook extends Remote {

	void removeByCode(String code) throws RemoteException;
	
	Book findBy(String code) throws RemoteException;
}
