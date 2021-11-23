package Servidor;

public interface IBibliotecaServidor {
	//Recibe el comando de pedir libro desde el middleware
	public String RealizarBusquedaNombreLibro(String comandoLN);
	
	//Recibe el comando de pedir autor desde el middleware
	public String RealizarBusquedaNombreAutor(String comandoLN);
	
	

}
