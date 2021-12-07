package Cliente.bibliotecas.C;

import Cliente.EBibliotecaDestino;
import Cliente.IBibliotecaCliente;
import Cliente.IMiddlewareCliente;
import Cliente.Mensajes;

public class ImplCBibliotecaCliente implements IBibliotecaCliente {

	@Override
	public String RealizarSolicitud(String comandoLN, IMiddlewareCliente implMiddlewareCliente,
			EBibliotecaDestino letraDestino) {
		// Validar y encaminar peticion
		
				if(comandoLN.startsWith("Encontrar Vol")){
					//Pedir Libro case
					//System.out.println("COMANDO: " + comandoLN);
					String respuesta = implMiddlewareCliente.GetTitle(comandoLN, letraDestino);
					return respuesta;
					
				}else if(comandoLN.startsWith("Encontrar Autor")){
					//Pedir Autor case
					String respuesta = implMiddlewareCliente.GetAuthor(comandoLN, letraDestino);
					return respuesta;
					
				}else{
					return Mensajes.COMANDO_NO_RECONOCIDO.name();
				}
	}

}
