package Servidor.bibliotecas.A;

import java.io.IOException;

import Servidor.IBibliotecaServidor;
import Servidor.LogWriter;
import Servidor.Servidor;

public class ImplABibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
		String nombreLibro = comandoLN.split("Pedir Libro")[1].trim();
		//System.out.println("-Nombre: " + nombreLibro);
		//System.out.println("-ComandoLN: " + comandoLN);
	
		// 2- Buscar en repositorio
		
		// 3- Codificar en LN primera respuesta
		String respuestaLN = "Libro " + "Spider-man ALibro";

		//4- Responder
		
		return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Pedir Autor")[1].trim();
		
		// 2- Buscar en repositorio
		
		// 3- Codificar en LN primera respuesta
		String respuestaLN = "Libro " + "Spider-man AAutor";
		
		// 4- Guardar mensaje en archivo
		LogWriter log = new LogWriter();
		try {
			System.out.println("Creando archivo");
			log.crearArchivo();
			log.escribirArchivo(autorLibro);
			System.out.println("Escritura en archivo finalizada");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return respuestaLN;
	}

}
