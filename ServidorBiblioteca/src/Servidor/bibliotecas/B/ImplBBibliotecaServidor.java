package Servidor.bibliotecas.B;

import Servidor.IBibliotecaServidor;

public class ImplBBibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
				String nombreLibro = comandoLN.split("Buscar T�tulo")[0].trim();
				
				// 2- Buscar en repositorio
				
				// 3- Codificar en LN primera respuesta
				String respuestaLN = "T�tulo " + "Spider-man BLibro";
				
				return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// 1- Obtener autor
		String autorLibro = comandoLN.split("Buscar Autor")[0].trim();
		
		// 2- Buscar en repositorio
		
		// 3- Codificar en LN primera respuesta
		String respuestaLN = "T�tulo " + "Spider-man BAutor";
		
		return respuestaLN;
	}

}
