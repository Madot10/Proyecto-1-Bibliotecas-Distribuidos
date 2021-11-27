package Servidor.bibliotecas.C;

import Servidor.IBibliotecaServidor;

public class ImplCBibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
				String nombreLibro = comandoLN.split("Encontrar Vol")[0].trim();
				
				// 2- Buscar en repositorio
				
				// 3- Codificar en LN primera respuesta
				String respuestaLN = "Vol " + "Spider-man 4";
				
				return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Encontrar Autor")[0].trim();
		
		// 2- Buscar en repositorio
		
		// 3- Codificar en LN primera respuesta
		String respuestaLN = "Vol " + "Spider-man 0";
		
		return respuestaLN;
	}

}
