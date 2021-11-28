package Servidor.bibliotecas.A;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Servidor.IBibliotecaServidor;
import Servidor.IMiddlewareServidor;
import Servidor.LogWriter;

public class ImplAMiddlewareServidor extends UnicastRemoteObject implements IMiddlewareServidor {
	
	private IBibliotecaServidor implBiblioteca;
	
	public ImplAMiddlewareServidor(IBibliotecaServidor implBiblioteca) throws RemoteException{
		super();
		this.implBiblioteca = implBiblioteca;
	}

	@Override
	public String GetTitle(String cmdTitle) {
		// 1- Decodificar Z a LN
		String peticion = "Pedir Libro " + cmdTitle.split("Get Title")[0].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		System.out.println("Respuesta a enviar: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Libro",1)[0].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ);
		
		// 4- Enviar
		return respuestaZ;
	}

	@Override
	public String GetAuthor(String cmdAuthor) {
		// 1- Decodificar Z a LN
		String peticion = "Pedir Autor " + cmdAuthor.split("Get Author")[0].trim();
		System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreAutor(peticion);
		System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Libro",1)[0].trim();
		System.out.println("RespuestaZZZZ: " + respuestaZ);

		// 4- Enviar
		return respuestaZ;
		
	}

}
