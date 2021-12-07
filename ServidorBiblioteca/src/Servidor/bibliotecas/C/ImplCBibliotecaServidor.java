package Servidor.bibliotecas.C;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Servidor.IBibliotecaServidor;
import Servidor.bibliotecas.B.LecturaBibliotecaB;

public class ImplCBibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
				String nombreLibro = comandoLN.split("Encontrar Vol")[1].trim();
				
				// 2- Buscar en repositorio

				LecturaBibliotecaC bibliotecaC = new LecturaBibliotecaC();
				String respuestaBiblioteca = "";
				try {
					respuestaBiblioteca = bibliotecaC.leerLibro(nombreLibro);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}

				//System.out.println("RESPUESTA BIBLIOTECA");
				//System.out.println(respuestaBiblioteca);
				
				// 3- Codificar en LN primera respuesta
				//String respuestaLN = "Vol " + "Spider-man CLibro";
				String respuestaLN = respuestaBiblioteca;
				
				return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Encontrar Autor")[1].trim();
		
		// 2- Buscar en repositorio
		LecturaBibliotecaC bibliotecaC = new LecturaBibliotecaC();
		String respuestaBiblioteca = "";
		try {
			respuestaBiblioteca = bibliotecaC.leerAutor(autorLibro);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		//System.out.println("RESPUESTA BIBLIOTECA");
		//System.out.println(respuestaBiblioteca);
		
		// 3- Codificar en LN primera respuesta
		//String respuestaLN = "Vol " + "Spider-man CAutor";
		String respuestaLN = respuestaBiblioteca;
		
		return respuestaLN;
	}

}
