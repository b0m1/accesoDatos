import java.io.File;

public class Actividad1 {
    public void datosDirectorio(File directorio) {

        if (directorio.isDirectory()) {

            for (int i = 0; i < directorio.listFiles().length; i++) {
                if (directorio.listFiles()[i].isDirectory()) {
                    System.out.printf("Directorio: %s\n", directorio.listFiles()[i].getName());
                }
            }
            for (int i = 0; i < directorio.listFiles().length; i++) {
                if (directorio.listFiles()[i].isFile()) {
                    System.out.printf("Archivo: %s\n", directorio.listFiles()[i].getName());
                }
            }
            // System.out.printf("%s %s\n", directorio.listFiles()[i].isDirectory() ?
            // "Directorio" : "Archivo", directorio.listFiles()[i].getName());

        } else {
            System.out.println(directorio.getName());
        }
    }

    public static void main(String[] args) {
        Actividad1 a1 = new Actividad1();
        File url = new File("C:\\Users\\Mónica");
        a1.datosDirectorio(url);
    }
}