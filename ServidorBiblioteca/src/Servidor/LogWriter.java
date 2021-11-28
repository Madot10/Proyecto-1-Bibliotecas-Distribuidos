package Servidor;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

    private File file;
    private String filePath = "log.txt";
    

	public void crearArchivo() throws IOException {
        this.file = new File(this.filePath);
        this.file.createNewFile();
    }
	
	public void escribirArchivo(String mensaje) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        FileWriter writer = new FileWriter(this.file);
        writer.write("[Fecha del mensaje] -> " + dtf.format(time) + " [mensaje] -> " + mensaje + "\n");
        writer.close();
    }
}
