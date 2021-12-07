package Servidor.bibliotecas.A;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import Servidor.IBibliotecaServidor;
import Servidor.IMiddlewareServidor;
import Servidor.LogWriter;
import Servidor.Servidor;

public class ImplAMiddlewareServidor extends UnicastRemoteObject implements IMiddlewareServidor {
	
	private IBibliotecaServidor implBiblioteca;
	
	public ImplAMiddlewareServidor(IBibliotecaServidor implBiblioteca) throws RemoteException{
		super();
		this.implBiblioteca = implBiblioteca;
	}

	@Override
	public String GetTitle(String cmdTitle, String bibliotecaOrigen) throws RemoteException{
		// 1- Decodificar Z a LN
		////System.out.println("+Llega: " + cmdTitle);
		String peticion = "Pedir Libro " + cmdTitle.split("Get Title")[1].trim();

		//Registrar entrada
		Servidor.registrarEnLog(cmdTitle, true, bibliotecaOrigen);
		////System.out.println("Traduccion peticion: " + peticion);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Libro",1)[0].trim();
		//System.out.println("Respuesta a enviar: " + respuestaLN + " EN Z: " + respuestaZ);
		
		//Registrar salida
		Servidor.registrarEnLog(respuestaZ, false);
		
		// 4- Enviar
		return respuestaZ;
	}

	@Override
	public String GetAuthor(String cmdAuthor, String bibliotecaOrigen) throws RemoteException{
		// 1- Decodificar Z a LN
		String peticion = "Pedir Autor " + cmdAuthor.split("Get Author")[1].trim();
		//System.out.println("Traduccion peticion: " + peticion);
		
		//Registrar entrada
		Servidor.registrarEnLog(cmdAuthor, true, bibliotecaOrigen);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreAutor(peticion);
		//System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Libro",1)[0].trim();
		//System.out.println("RespuestaZZZZ: " + respuestaZ);
		
		//Registrar salida
		Servidor.registrarEnLog(respuestaZ, false);
				

		// 4- Enviar
		return respuestaZ;
		
	}

}
