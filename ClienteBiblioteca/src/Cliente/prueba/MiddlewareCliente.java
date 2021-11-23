package Cliente.prueba;

import java.rmi.RemoteException;

public interface MiddlewareCliente {
	public String pedirRecurso(String recurso) throws RemoteException;
}
