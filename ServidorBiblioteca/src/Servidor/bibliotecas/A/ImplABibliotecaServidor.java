package Servidor.bibliotecas.A;

import Servidor.IBibliotecaServidor;

public class ImplABibliotecaServidor implements IBibliotecaServidor {

	@Override
	public String RealizarBusquedaNombreLibro(String comandoLN) {
		// 1- Obtener nombre
		String nombreLibro = comandoLN.split("Pedir Libro")[0].trim();
		
		// 2- Buscar en repositorio
		
		// 3- Codificar en LN primera respuesta
		String respuestaLN = "Libro " + "Spider-man 4";
		
		return respuestaLN;
	}

	@Override
	public String RealizarBusquedaNombreAutor(String comandoLN) {
		// TODO Auto-generated method stub
		return null;
	}

}
