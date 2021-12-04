package Cliente.bibliotecas.C;

import java.rmi.Naming;
import java.rmi.RemoteException;

import Cliente.Cliente;
import Cliente.EBibliotecaDestino;
import Cliente.IMiddlewareCliente;
import Cliente.Mensajes;
import Servidor.IMiddlewareServidor;

public class ImplCMiddlewareCliente implements IMiddlewareCliente {

	@Override
	public String GetTitle(String cmdTitle, EBibliotecaDestino letraDestino) {
		// 1- Construir nuevo comando
				String ZTitle = "Get Title " + cmdTitle.split("Encontrar Vol")[1].trim(); 
				
				// 2- Construir url RMI
				String url = Cliente.obtenerURLrmi(letraDestino) ;
				System.out.println("RMI URL: " + url);
				
				//Registrar salida
				Cliente.registrarEnLog(cmdTitle,false);
				Cliente.registrarEnLog(ZTitle + "| Destino: " + letraDestino.name(),false);
				
				// 3- Llamar metodo remoto
				try {

					IMiddlewareServidor srv = (IMiddlewareServidor) Naming.lookup(url);

					String resultadoZ = srv.GetTitle(ZTitle, "C");
		            System.out.println("RespuestaZ: " + resultadoZ);
		            
		         // 4- Decodificar a LN
		            String resultadoLN = "Vol " + resultadoZ.split("Title")[1].trim();
		            
		            //Registrar entrada
		    		Cliente.registrarEnLog(resultadoZ,true);
		            
		            return resultadoZ.split("Title")[1].trim();
		        }
		        catch (RemoteException e) {
		            System.err.println("Error de comunicacion: " + e.toString());
		        }
		        catch (Exception e) {
		            System.err.println("Excepcion en MiddlewareClienteImpl:");
		            e.printStackTrace();
		        }
				
				return Mensajes.ERROR.name();
	}

	@Override
	public String GetAuthor(String cmdAuthor, EBibliotecaDestino letraDestino) {
		// 1- Construir nuevo comando
		String ZAuthor = "Get Author " + cmdAuthor.split("Encontrar Autor")[1].trim(); 
		
		// 2- Construir url RMI
		String url = Cliente.obtenerURLrmi(letraDestino);
		System.out.println("RMI URL: " + url);
		
		//Registrar salida
		Cliente.registrarEnLog(cmdAuthor,false);
		Cliente.registrarEnLog(ZAuthor + "| Destino: " + letraDestino.name(),false);
		
		// 3- Llamar metodo remoto
		try {

			IMiddlewareServidor srv = (IMiddlewareServidor) Naming.lookup(url);

			String resultadoZ = srv.GetAuthor(ZAuthor, "C");
            System.out.println("RespuestaZ: " + resultadoZ);
            
         // 4- Decodificar a LN
            String resultadoLN = "Vol " + resultadoZ.split("Title")[1].trim();
            
            //Registrar entrada
    		Cliente.registrarEnLog(resultadoZ,true);
            
            return resultadoZ.split("Title")[1].trim();
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en MiddlewareClienteImpl:");
            e.printStackTrace();
        }
		
		return Mensajes.ERROR.name();
	}

}
