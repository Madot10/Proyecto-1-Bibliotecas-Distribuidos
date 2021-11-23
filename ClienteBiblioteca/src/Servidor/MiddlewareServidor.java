package Servidor;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiddlewareServidor extends Remote {
	public String obtenerRecurso (String peticion) throws RemoteException;
}
