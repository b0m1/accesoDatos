import java.io.File;
import java.io.FileReader;

public class Actividad3 {
    public int encontrarChar(char caracter, File archivo) {
        int letra;
        int cont = 0;
        try (FileReader archivoLeido = new FileReader(archivo);) {

            while ((letra = archivoLeido.read()) != -1) {

                if (letra == ((int) caracter)) {
                    cont++;
                }

            }
            System.out.println("Num de veces que sale el caracter " + caracter + ": " + cont);
        } catch (Exception e) {
            System.out.println("Asfasdasd" +e.getLocalizedMessage());
        }
        return cont;
    }

    public static void main(String[] args) {
        Actividad3 a3 = new Actividad3();
        File test = new File("C:\\Users\\Mónica\\Desktop\\test.txt");
        a3.encontrarChar('e', test);
    }
}
