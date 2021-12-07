package Servidor.bibliotecas.B;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Servidor.IBibliotecaServidor;
import Servidor.IMiddlewareServidor;
import Servidor.Servidor;

public class ImplBMiddlewareServidor extends UnicastRemoteObject implements IMiddlewareServidor {
	
private IBibliotecaServidor implBiblioteca;
	
	public ImplBMiddlewareServidor(IBibliotecaServidor implBiblioteca) throws RemoteException{
		super();
		this.implBiblioteca = implBiblioteca;
	}

	@Override
	public String GetTitle(String cmdTitle, String bibliotecaOrigen) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar Título " + cmdTitle.split("Get Title")[1].trim();
		//System.out.println("Traduccion peticion: " + peticion);
		
		//Registrar entrada
		Servidor.registrarEnLog(cmdTitle, true, bibliotecaOrigen);
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreLibro(peticion);
		//System.out.println("Respuesta a enviar: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Título",1)[0].trim();
		//System.out.println("RespuestaZZZZ: " + respuestaZ + "\n " + respuestaLN.split("Título")[0]);
		
		//Registrar salida
				Servidor.registrarEnLog(respuestaZ, false);
		
		// 4- Enviar
		return respuestaZ;
	}

	@Override
	public String GetAuthor(String cmdAuthor, String bibliotecaOrigen) throws RemoteException {
		// 1- Decodificar Z a LN
		String peticion = "Buscar Autor " + cmdAuthor.split("Get Author")[1].trim();
		//System.out.println("Traduccion peticion: " + peticion);
		
		//Registrar entrada
				Servidor.registrarEnLog(cmdAuthor, true, bibliotecaOrigen);
			
		
		// 2- Llamar metodo biblioteca servidor
		String respuestaLN = implBiblioteca.RealizarBusquedaNombreAutor(peticion);
		//System.out.println("Respuesta: " + respuestaLN);
		
		// 3- Codificar a Z respuesta
		String respuestaZ = "Title " + respuestaLN.split("Título",1)[0].trim();
		//System.out.println("RespuestaZZZZ: " + respuestaZ);
		
		//Registrar salida
				Servidor.registrarEnLog(respuestaZ, false);
		
		// 4- Enviar
		return respuestaZ;
	}

}
