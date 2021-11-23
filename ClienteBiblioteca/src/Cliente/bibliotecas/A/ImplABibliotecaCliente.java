package Cliente.bibliotecas.A;

import Cliente.EBibliotecaDestino;
import Cliente.IBibliotecaCliente;
import Cliente.IMiddlewareCliente;
import Cliente.Mensajes;

public class ImplABibliotecaCliente implements IBibliotecaCliente {
	
	@Override
	public String RealizarSolicitud(String comandoLN, IMiddlewareCliente implMiddlewareCliente,
			EBibliotecaDestino letraDestino) {
		// Validar y encaminar peticion
		
		if(comandoLN.startsWith("Pedir Libro")){
			//Pedir Libro case
			System.out.println("COMANDO: " + comandoLN);
			String respuesta = implMiddlewareCliente.GetTitle(comandoLN, letraDestino);
			return respuesta;
			
		}else if(comandoLN.startsWith("Pedir Autor")){
			//Pedir Autor case
			String respuesta = implMiddlewareCliente.GetAuthor(comandoLN, letraDestino);
			return respuesta;
			
		}else{
			return Mensajes.COMANDO_NO_RECONOCIDO.name();
		}
		
		
	}

}
