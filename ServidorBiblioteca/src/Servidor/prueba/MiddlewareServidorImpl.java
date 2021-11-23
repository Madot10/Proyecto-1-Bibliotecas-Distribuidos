package Servidor.prueba;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MiddlewareServidorImpl extends UnicastRemoteObject implements MiddlewareServidor {

	protected MiddlewareServidorImpl() throws RemoteException {
		super();
	}

	@Override
	public String obtenerRecurso(String peticion) throws RemoteException {
		System.out.println("Devolviendo recurso");
		return "Libro 1 por MM";
	}

}
