package Servidor.bibliotecas.B;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Servidor.IBibliotecaServidor;
import Servidor.IMiddlewareServidor;

public class ImplBMiddlewareServidor extends UnicastRemoteObject implements IMiddlewareServidor {
	
private IBibliotecaServidor implBiblioteca;
	
	public ImplBMiddlewareServidor(IBibliotecaServidor implBiblioteca) throws RemoteException{
		super();
		this.implBiblioteca = implBiblioteca;
	}

	@Override
	public String GetTitle(String cmdTitle) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar T�tulo " + cmdTitle.split("Get Title")[1].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		System.out.println("Respuesta a enviar: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("T�tulo",1)[0].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ + "\n " + respuestaLN.split("T�tulo")[1]);
		
		// 4- Enviar
		return respuestaZ;
	}

	@Override
	public String GetAuthor(String cmdAuthor) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar Autor " + cmdAuthor.split("Get Author")[1].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreAutor(peticion);
		System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("T�tulo",1)[0].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ);
		
		// 4- Enviar
		return respuestaZ;
	}

}
