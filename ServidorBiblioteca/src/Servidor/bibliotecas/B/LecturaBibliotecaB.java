package Servidor.bibliotecas.B;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

public class LecturaBibliotecaB {

	private String respuesta;
	
    /*
     * En caso de que se consulte un libro:
     * 		Se responde con autor y libro
     * En caso de que se consulte autor:
     * 		Se responde con todos los libros de ese autor 
    */

	public String leerLibro(String libro) throws ParserConfigurationException,
    SAXException, IOException {
		try {
			
            File inputFile = new File("src/Servidor/bibliotecas/B/biblioteca B.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            Element books = classElement.getChild("bibliotecaB");
            List<Element> bookList = books.getChildren("book");
            System.out.println("----------------------------");
            System.out.println("Lista de libros");
            System.out.println(bookList.toString());
            System.out.println("----------------------------");
            
            String respuesta = "";
            
            System.out.println("SOLICITUD DE LIBRO");

            for (Element book : bookList) {
            	System.out.println("**** " + book.getChildText("titulo") + "===" + libro + " --- "  + book.getChildText("titulo").toLowerCase().contains(libro.toLowerCase()));
            	if(book.getChildText("titulo").toLowerCase().contains(libro.toLowerCase())) {
            		respuesta =  book.getChildText("titulo") + ", " + book.getChildText("autor");
	                System.out.println(respuesta);
	                System.out.println("----------------------------");
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
			this.respuesta = "No se encontró";
		}
		return this.respuesta;
	}
	

	public String leerAutor(String autor) throws ParserConfigurationException,
    SAXException, IOException {
		try {
			
            File inputFile = new File("src/Servidor/bibliotecas/B/biblioteca B.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            Element books = classElement.getChild("bibliotecaB");
            List<Element> bookList = books.getChildren("book");
            System.out.println("----------------------------");
            System.out.println("Lista de libros");
            System.out.println(bookList);
            System.out.println("----------------------------");
            
            String respuesta = "";
            
            System.out.println("SOLICITUD DE AUTOR");
            
            respuesta = "Libros del autor " + autor + ": ";
            for (Element book : bookList) {
            	if(book.getChildText("autor").toLowerCase().contains(autor.toLowerCase())) {
            		respuesta = respuesta + book.getChildText("titulo") + ", ";
            	}
            }
            respuesta = respuesta.substring(0, respuesta.length()-2);
            System.out.println(respuesta);
            this.respuesta = respuesta;
            System.out.println("----------------------------"); 
            
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

		if(this.respuesta == null){
			this.respuesta = "No se encontró";
		}
		return this.respuesta;
		
	}

}
