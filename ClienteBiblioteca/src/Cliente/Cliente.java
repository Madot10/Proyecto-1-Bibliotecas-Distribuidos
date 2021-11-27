package Cliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	
	public static String obtenerURLrmi(EBibliotecaDestino letraDestino){
		String ip = null;
		String port = null;
		
		 try (InputStream input = new FileInputStream("src/resources/config.properties")) {

	            Properties prop = new Properties();
	            String destino = letraDestino.name();

	            // load a properties file
	            prop.load(input);

	            ip = prop.getProperty(destino + ".ip");
	            port = prop.getProperty(destino + ".port");
	            
	            System.out.println(ip);
	            System.out.println(port);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
		
		String urlRMI = "rmi://" + ip + ":" + port;
		
		return urlRMI;
	}

}
