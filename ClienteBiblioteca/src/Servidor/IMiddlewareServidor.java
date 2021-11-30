package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddlewareServidor extends Remote{
	public String GetTitle (String cmdTitle, String bibliotecaOrigen) throws RemoteException;
	
	public String GetAuthor (String cmdAuthor, String bibliotecaOrigen) throws RemoteException;
}
