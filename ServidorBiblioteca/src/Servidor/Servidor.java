package Servidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.Scanner;

import Servidor.bibliotecas.A.ImplABibliotecaServidor;
import Servidor.bibliotecas.A.ImplAMiddlewareServidor;
import Servidor.bibliotecas.B.ImplBBibliotecaServidor;
import Servidor.bibliotecas.B.ImplBMiddlewareServidor;
import Servidor.bibliotecas.C.ImplCBibliotecaServidor;
import Servidor.bibliotecas.C.ImplCMiddlewareServidor;

public class Servidor  {
	public static IMiddlewareServidor implMiddleware;

/*
	public static void main(String[] args) {
		// SecurityManager
		//if(System.getSecurityManager() == null){
			//System.setSecurityManager(new SecurityManager());
		//}
		
		//RMI
		try{
			
			
			System.out.println("Server running");
		}catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en MiddlewareServidorImpls:");
            e.printStackTrace();
            System.exit(1);
        }

	}*/

	public static void main(String[] args) {
		// 1- Seleccionar biblioteca a ejecutar
		String modoActivo = inicializarServidor();
		
		// 2- Modo escucha

		try{
			// 2.1 - Lee propiedades por puerto
			// 2.2 - Vincula middleware
			Registry reg = LocateRegistry.createRegistry(obtenerPuerto(modoActivo));
			reg.rebind("Biblioteca" + modoActivo, implMiddleware);
			
			System.out.println("Server running " + modoActivo);
		}catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en MiddlewareServidorImpls:");
            e.printStackTrace();
            System.exit(1);
        }
		
		//System.out.println("Bye");
	}
	
	public static String inicializarServidor(){
		
		Scanner input = new Scanner(System.in);
		 
		System.out.println("========= SERVIDOR MODO ===========");
		System.out.println("1- Biblioteca A");
		System.out.println("2- Biblioteca B");
		System.out.println("3- Biblioteca C");
		System.out.println("====================");
		System.out.print("Num. selección: ");
        String opc = input.nextLine();
        
        try {
	        switch(opc){
	        	case "1":
					implMiddleware = new ImplAMiddlewareServidor(new ImplABibliotecaServidor());
	        		return "A";
	        		
	        	case "2":
	        		implMiddleware = new ImplBMiddlewareServidor(new ImplBBibliotecaServidor());
	        		return "B";
	        		
	        	case "3":
	        		implMiddleware = new ImplCMiddlewareServidor(new ImplCBibliotecaServidor());
	        		return "C";
	        		
	        	default:
	        		System.out.println("Opción invalida! ");
	        		System.exit(500);
	        		return "NULL";
	        }
        } catch (RemoteException e) {
			System.out.println("Error al inicializar servidor: ");
			e.printStackTrace();
		}
        
		return null;
	
    }
	
	public static int obtenerPuerto(String modoActivo){
		try (InputStream input = new FileInputStream("src/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(modoActivo + ".port"));
            return  Integer.parseInt(prop.getProperty(modoActivo + ".port"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return 0;
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

