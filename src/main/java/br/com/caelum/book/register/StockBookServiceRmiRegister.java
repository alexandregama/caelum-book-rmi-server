package br.com.caelum.book.register;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import br.com.caelum.book.service.StockBookService;

public class StockBookServiceRmiRegister {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		LocateRegistry.createRegistry(1099);
		Naming.bind("/stockservice", new StockBookService());
		
		System.out.println("StockBookService is up and running!");
	}
	
}
