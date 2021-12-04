package Servidor.bibliotecas.B;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Servidor.IBibliotecaServidor;
import Servidor.bibliotecas.A.LecturaBibliotecaA;

public class ImplBBibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
		
				String nombreLibro = comandoLN.split("Buscar Título")[1].trim();
				
				// 2- Buscar en repositorio

				LecturaBibliotecaB bibliotecaB = new LecturaBibliotecaB();
				String respuestaBiblioteca = "";
				try {
					respuestaBiblioteca = bibliotecaB.leerLibro(nombreLibro);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}

				System.out.println("RESPUESTA BIBLIOTECA");
				System.out.println(respuestaBiblioteca);
				
				// 3- Codificar en LN primera respuesta
				//String respuestaLN = "Título " + "Spider-man BLibro";
				String respuestaLN = respuestaBiblioteca;
						
				return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Buscar Autor")[1].trim();
		
		// 2- Buscar en repositorio
				LecturaBibliotecaB bibliotecaB = new LecturaBibliotecaB();
				String respuestaBiblioteca = "";
				try {
					respuestaBiblioteca = bibliotecaB.leerAutor(autorLibro);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}

				System.out.println("RESPUESTA BIBLIOTECA");
				System.out.println(respuestaBiblioteca);
		
		
		// 3- Codificar en LN primera respuesta
		//String respuestaLN = "Título " + "Spider-man BAutor";
				String respuestaLN = respuestaBiblioteca;
		
		return respuestaLN;
	}

}
