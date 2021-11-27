package Servidor.bibliotecas.B;

import java.rmi.RemoteException;

import Servidor.IBibliotecaServidor;
import Servidor.IMiddlewareServidor;

public class ImplBMiddlewareServidor implements IMiddlewareServidor {
	
private IBibliotecaServidor implBiblioteca;
	
	public ImplBMiddlewareServidor(IBibliotecaServidor implBiblioteca) throws RemoteException{
		super();
		this.implBiblioteca = implBiblioteca;
	}

	@Override
	public String GetTitle(String cmdTitle) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar Título " + cmdTitle.split("Get Title")[0].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Título")[1].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ + "\n " + respuestaLN.split("Título")[1]);
		
		// 4- Enviar
		return respuestaZ;
	}

	@Override
	public String GetAuthor(String cmdAuthor) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar Autor " + cmdAuthor.split("Get Author")[0].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Título")[1].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ + "\n " + respuestaLN.split("Título")[1]);
		
		// 4- Enviar
		return respuestaZ;
	}

}
