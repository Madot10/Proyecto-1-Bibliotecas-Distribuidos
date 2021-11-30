package Cliente;
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
        FileWriter writer = new FileWriter(this.file, true);
        System.out.println("[LOG] Escribiendo " + mensaje);
        writer.write("[" + dtf.format(time) + "] -> "  + mensaje + "\n");
        writer.close();
    }
}
