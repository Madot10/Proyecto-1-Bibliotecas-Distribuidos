package Cliente;

public interface IMiddlewareCliente {
	public String GetTitle (String cmdTitle, EBibliotecaDestino letraDestino);
	
	public String GetAuthor (String cmdAuthor, EBibliotecaDestino letraDestino);
}
