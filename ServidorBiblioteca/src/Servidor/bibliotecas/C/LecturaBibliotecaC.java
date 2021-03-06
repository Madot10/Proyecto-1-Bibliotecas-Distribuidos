package Servidor.bibliotecas.C;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

public class LecturaBibliotecaC {

	private String respuesta;
	
    /*
     * En caso de que se consulte un libro:
     * 		Se responde con autor y libro
     * En caso de que se consulte autor:
     * 		Se responde con todos los libros de ese autor 
    */

	public synchronized  String leerLibro(String libro) throws ParserConfigurationException,
    SAXException, IOException {
		try {
			
            File inputFile = new File("src/Servidor/bibliotecas/C/biblioteca C.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            Element books = classElement.getChild("bibliotecaC");
            List<Element> bookList = books.getChildren("book");
            //System.out.println("----------------------------");
            //System.out.println("Lista de libros");
            //System.out.println(bookList.toString());
            //System.out.println("----------------------------");
            
            String respuesta = "";
            
            //System.out.println("SOLICITUD DE LIBRO");

            for (Element book : bookList) {
            
            	if(book.getChildText("vol").toLowerCase().contains(libro.toLowerCase())) {
            		respuesta =  book.getChildText("vol") + ", " + book.getChildText("autor");
	                //System.out.println(respuesta);
	                //System.out.println("----------------------------");
	                this.respuesta = respuesta;
	                break;
            	}
            }
            
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
		
		if(this.respuesta == null){
			this.respuesta = "No se encontr?";
		}
		return this.respuesta;
	}
	

	public synchronized  String leerAutor(String autor) throws ParserConfigurationException,
    SAXException, IOException {
		boolean isFound = false;
		try {
			
            File inputFile = new File("src/Servidor/bibliotecas/C/biblioteca C.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            Element books = classElement.getChild("bibliotecaC");
            List<Element> bookList = books.getChildren("book");
            //System.out.println("----------------------------");
            //System.out.println("Lista de libros");
            //System.out.println(bookList);
            //System.out.println("----------------------------");
            
            String respuesta = "";
            
            //System.out.println("SOLICITUD DE AUTOR");
            
            respuesta = "Libros del autor " + autor + ": ";
            for (Element book : bookList) {
            	if(book.getChildText("autor").toLowerCase().contains(autor.toLowerCase())) {
            		respuesta = respuesta + book.getChildText("vol") + ", ";
            		isFound = true;
            	}
            }
            respuesta = respuesta.substring(0, respuesta.length()-2);
            //System.out.println(respuesta);
            this.respuesta = respuesta;
            //System.out.println("----------------------------"); 
            
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

		if(this.respuesta == null || !isFound){
			this.respuesta = "No se encontr?";
		}
		return this.respuesta;
		
	}
}
