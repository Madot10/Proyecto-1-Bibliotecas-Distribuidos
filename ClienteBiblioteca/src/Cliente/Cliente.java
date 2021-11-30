package Cliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import Cliente.bibliotecas.A.ImplABibliotecaCliente;
import Cliente.bibliotecas.A.ImplAMiddlewareCliente;
import Cliente.bibliotecas.B.ImplBBibliotecaCliente;
import Cliente.bibliotecas.B.ImplBMiddlewareCliente;
import Cliente.bibliotecas.C.ImplCBibliotecaCliente;
import Cliente.bibliotecas.C.ImplCMiddlewareCliente;

public class Cliente {

	public static IBibliotecaCliente implBiblioteca;
	public static IMiddlewareCliente implMiddlewareCliente;
	public static EBibliotecaDestino bibliotecaDestino;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String bibliotecaActiva;
	  
		// 1- Seleccionar biblioteca a ejecutar
		bibliotecaActiva = inicializarCliente();
		
		//2- Pedir biblioteca destino
		bibliotecaDestino = inicializarBibliotecaDestino();
		
		//3- Realizar solicitud
		System.out.println();
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("¡Bienvenido al cliente de la Biblioteca " + bibliotecaActiva + "!");
		System.out.print("Realice su petición: ");
		String comando = input.nextLine();
		
		String resp = implBiblioteca.RealizarSolicitud(comando, implMiddlewareCliente, bibliotecaDestino);

		//4- Mostrar respuesta
		System.out.println();
		System.out.println("*** ESPERANDO RESPUESTA ***");
		System.out.println();
		System.out.println("Respuesta:");
		System.out.println(resp);
		System.out.println();
		System.out.println("*** FIN DEL MENSAJE ***");
		
		//PRUEBA A
		//implBiblioteca = new ImplABibliotecaCliente();
		//implMiddlewareCliente = new ImplAMiddlewareCliente();
		
		
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
		
		
		String urlRMI = "rmi://" + ip + ":" + port + "/Biblioteca" + letraDestino.name();
		
		return urlRMI;
	}

	
	public static String inicializarCliente(){
		Scanner input = new Scanner(System.in);
		 
		System.out.println("========= CLIENTE MODO ===========");
		System.out.println("1- Biblioteca A");
		System.out.println("2- Biblioteca B");
		System.out.println("3- Biblioteca C");
		System.out.println("====================");
		System.out.print("Num. selección: ");
        String opc = input.nextLine();
        
        switch(opc){
        	case "1":
        		implBiblioteca = new ImplABibliotecaCliente();
        		implMiddlewareCliente = new ImplAMiddlewareCliente();
        		return "A";
        		
        	case "2":
        		implBiblioteca = new ImplBBibliotecaCliente();
        		implMiddlewareCliente = new ImplBMiddlewareCliente();
        		return "B";
        		
        	case "3":
        		implBiblioteca = new ImplCBibliotecaCliente();
        		implMiddlewareCliente = new ImplCMiddlewareCliente();
        		return "C";
        		
        	default:
        		System.out.println("Opción invalida! ");
        		System.exit(500);
        		return "NULL";
        	
        }
		
	}
	
	public static EBibliotecaDestino inicializarBibliotecaDestino(){
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		System.out.println("========= DESTINO ===========");
		System.out.println("1- Biblioteca A");
		System.out.println("2- Biblioteca B");
		System.out.println("3- Biblioteca C");
		System.out.println("====================");
		System.out.print("Num. selección: ");
        String opc = input.nextLine();
        
        switch(opc){
        	case "1":
        		return EBibliotecaDestino.A;
        		
        	case "2":
        		return EBibliotecaDestino.B;
        		
        	case "3":
        		return EBibliotecaDestino.C;
        		
        	default:
        		System.out.println("Opción invalida! ");
        		System.exit(500);
        		break;
        }
		return null;
	}

	public static void registrarEnLog(String mensaje, boolean esRecepcion){
		LogWriter log = new LogWriter();
		try {
			System.out.println("Creando archivo");
			log.crearArchivo();
			log.escribirArchivo((esRecepcion ? "[ENTRANTE] " : "[SALIENTE] ") + mensaje);
			System.out.println("Escritura en archivo finalizada");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
