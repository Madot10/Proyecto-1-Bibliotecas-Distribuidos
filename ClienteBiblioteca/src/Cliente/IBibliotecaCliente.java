package Cliente;

public interface IBibliotecaCliente {
	//Recibe el comando de pedir libro o autor desde consola
	public String RealizarSolicitud(String comandoLN, IMiddlewareCliente implMiddlewareCliente, EBibliotecaDestino letraDestino);
}
