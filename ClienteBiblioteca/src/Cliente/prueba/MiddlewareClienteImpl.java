package Cliente.prueba;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import Servidor.MiddlewareServidor;


public class MiddlewareClienteImpl implements MiddlewareCliente {

	@Override
	public String pedirRecurso(String recurso) {
		//System.setProperty("java.security.policy", "file:src/sc.policy");
		//if (System.getSecurityManager() == null)
        //   System.setSecurityManager(new SecurityManager());

		try {

			MiddlewareServidor srv = (MiddlewareServidor) Naming.lookup("//localhost:54321/MiddleServer");

			String resultado = srv.obtenerRecurso(recurso);
            System.out.println("Respuesta: " + resultado);
            
            return resultado;
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en MiddlewareClienteImpl:");
            e.printStackTrace();
        }
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MiddlewareClienteImpl a = new MiddlewareClienteImpl();
		//System.out.println("Client Running");
		//a.pedirRecurso("Hola");
		
		 try (InputStream input = new FileInputStream("src/resources/config.properties")) {

	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println(prop.getProperty("a.port"));
	            System.out.println(prop.getProperty("a.url"));
	            System.out.println(prop.getProperty("b.port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}

}
