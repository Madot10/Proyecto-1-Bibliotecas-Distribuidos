package Servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.bibliotecas.A.ImplABibliotecaServidor;
import Servidor.bibliotecas.A.ImplAMiddlewareServidor;

public class Servidor  {


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
		
		// 2- Modo escucha
		
		try{
			//Prueba Impl A
			IMiddlewareServidor implAMidServer = new ImplAMiddlewareServidor(new ImplABibliotecaServidor());
			
			Registry reg = LocateRegistry.createRegistry(54325);
			reg.rebind("BibliotecaA", implAMidServer);
			
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
		
		//System.out.println("Bye");
	}
}
