package Cliente;

import Cliente.bibliotecas.A.ImplABibliotecaCliente;
import Cliente.bibliotecas.A.ImplAMiddlewareCliente;

public class Cliente {

	public void inicializar(String entrada){
		
	}
	
	public static void main(String[] args) {
		IBibliotecaCliente implBiblioteca;
		IMiddlewareCliente implMiddlewareCliente;
		
		// 1- Seleccionar biblioteca a ejecutar
		
		//2- Pedir biblioteca destino
		
		//3- Realizar solicitud
		
		//4- Mostrar respuesta
		
		
		//PRUEBA A
		implBiblioteca = new ImplABibliotecaCliente();
		implMiddlewareCliente = new ImplAMiddlewareCliente();
		
		String resp = implBiblioteca.RealizarSolicitud("Pedir Libro Avion", implMiddlewareCliente, EBibliotecaDestino.A);
		System.out.println("Repuesta en main: " + resp);
	}

}
