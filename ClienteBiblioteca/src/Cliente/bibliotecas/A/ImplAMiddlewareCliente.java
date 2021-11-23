package Cliente.bibliotecas.A;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import Cliente.EBibliotecaDestino;
import Cliente.IMiddlewareCliente;
import Cliente.Mensajes;
import Servidor.IMiddlewareServidor;

public class ImplAMiddlewareCliente implements IMiddlewareCliente {

	public String obtenerURLrmi(EBibliotecaDestino letraDestino){
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
	
	@Override
	public String GetTitle(String cmdTitle, EBibliotecaDestino letraDestino) {
		// 1- Construir nuevo comando
		String ZTitle = "Get Title " + cmdTitle.split("Pedir Libro")[0].trim(); 
		
		// 2- Construir url RMI
		String url = obtenerURLrmi(letraDestino) + "/BibliotecaA";
		System.out.println("RMI URL: " + url);
		
		// 3- Llamar metodo remoto
		try {

			IMiddlewareServidor srv = (IMiddlewareServidor) Naming.lookup(url);

			String resultadoZ = srv.GetTitle(ZTitle);
            System.out.println("RespuestaZ: " + resultadoZ);
            
         // 4- Decodificar a LN
            String resultadoLN = "Libro " + resultadoZ.split("Title")[1].trim();
            
            return resultadoLN;
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
		// TODO Auto-generated method stub
		return null;
	}
	

}
