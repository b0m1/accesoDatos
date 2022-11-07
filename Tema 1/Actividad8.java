import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Actividad8 {
    static void copiarArchivoBinario(File archivo, File archivoDestino){
        try (FileInputStream in = new FileInputStream(archivo);FileOutputStream out = new FileOutputStream(archivoDestino)) {
            int lecturaDatos;
            while ((lecturaDatos=in.read())!=-1) {            
                out.write(lecturaDatos);           
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    static void copiarConBuffer(File archivo,File archivoDestino){
        byte[] buffer = new byte[1000];
        int i;
        try (FileInputStream in = new FileInputStream(archivo);FileOutputStream out = new FileOutputStream(archivoDestino)) {
            while ((i=in.read(buffer))!=-1) {
                
                out.write(buffer,0, i);
               
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Monica\\Desktop\\fondo.jpg");
        File archivoDestino = new File("C:\\Users\\Monica\\Desktop\\fondo2.jpg");
        copiarConBuffer(archivo, archivoDestino);
    }
}
