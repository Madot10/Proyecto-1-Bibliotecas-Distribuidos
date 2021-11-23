package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddlewareServidor extends Remote{
	public String GetTitle (String cmdTitle) throws RemoteException;
	
	public String GetAuthor (String cmdAuthor) throws RemoteException;
}
