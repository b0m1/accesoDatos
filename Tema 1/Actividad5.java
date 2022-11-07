import java.io.File;
import java.util.Scanner;

public class Actividad5 {
    public static void encontrarCadena(File archivo, String cadena) {
        String linea="";
        int cont=0;
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNext()) {
                cont++;
                linea = sc.nextLine();
                if (linea.contains(cadena)) {
                    System.out.println(linea);
                    System.out.println("Num de linea: "+cont);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    
    public static void main(String[] args) {
        File archivo = new File("c:\\users\\monica\\desktop\\equipoEmpresa.txt");
        encontrarCadena(archivo, "Em");
    }
}
