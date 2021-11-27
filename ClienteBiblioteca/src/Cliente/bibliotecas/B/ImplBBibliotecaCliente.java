package Cliente.bibliotecas.B;

import Cliente.EBibliotecaDestino;
import Cliente.IBibliotecaCliente;
import Cliente.IMiddlewareCliente;
import Cliente.Mensajes;

public class ImplBBibliotecaCliente implements IBibliotecaCliente {

	@Override
	public String RealizarSolicitud(String comandoLN, IMiddlewareCliente implMiddlewareCliente,
			EBibliotecaDestino letraDestino) {
		// Validar y encaminar peticion
		
				if(comandoLN.startsWith("Buscar Título")){
					//Pedir Libro case
					System.out.println("COMANDO: " + comandoLN);
					String respuesta = implMiddlewareCliente.GetTitle(comandoLN, letraDestino);
					return respuesta;
					
				}else if(comandoLN.startsWith("Buscar Autor")){
					//Pedir Autor case
					String respuesta = implMiddlewareCliente.GetAuthor(comandoLN, letraDestino);
					return respuesta;
					
				}else{
					return Mensajes.COMANDO_NO_RECONOCIDO.name();
				}
	}

}
