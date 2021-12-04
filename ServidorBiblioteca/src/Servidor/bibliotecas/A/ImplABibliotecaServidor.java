package Servidor.bibliotecas.A;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Servidor.IBibliotecaServidor;
import Servidor.LogWriter;
import Servidor.Servidor;
import Servidor.bibliotecas.A.LecturaBibliotecaA;
import org.jdom2.JDOMException;

public class ImplABibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
		String nombreLibro = comandoLN.split("Pedir Libro")[1].trim();
		//System.out.println("-Nombre: " + nombreLibro);
		//System.out.println("-ComandoLN: " + comandoLN);
	
		// 2- Buscar en repositorio
		
		LecturaBibliotecaA bibliotecaA = new LecturaBibliotecaA();
		String respuestaBiblioteca = "";
		try {
			respuestaBiblioteca = bibliotecaA.leerLibro(nombreLibro);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("RESPUESTA BIBLIOTECA");
		System.out.println(respuestaBiblioteca);
		
		
		// 3- Codificar en LN primera respuesta
		//String respuestaLN = "Libro " + "Spider-man ALibro";
		String respuestaLN = respuestaBiblioteca;

		//4- Responder
		
		return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Pedir Autor")[1].trim();
		
		// 2- Buscar en repositorio
		LecturaBibliotecaA bibliotecaA = new LecturaBibliotecaA();
		String respuestaBiblioteca = "";
		try {
			respuestaBiblioteca = bibliotecaA.leerAutor(autorLibro);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("RESPUESTA BIBLIOTECA");
		System.out.println(respuestaBiblioteca);
		
		// 3- Codificar en LN primera respuesta
		//String respuestaLN = "Libro " + "Spider-man AAutor";
		String respuestaLN = respuestaBiblioteca;
		
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
