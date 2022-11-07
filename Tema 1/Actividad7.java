import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Actividad7 {
    public static void ejercicio7(String nombreArchivo, String operacion) {
        if (operacion == "n") {
            String linea = "";
            int numPalabras = 0;
            int numLineas = 0;

            try (Scanner sc = new Scanner(new File(nombreArchivo))) {
                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    numLineas++;
                    Scanner lineas = new Scanner(linea);
                    while (lineas.hasNext()) {
                        lineas.next();
                        numPalabras++;
                    }
                    lineas.close();
                }
            } catch (Exception e) {
               System.err.println(e.getLocalizedMessage());
            }
            System.err.println(numLineas + "lineas " + numPalabras + "palabras");
        } else {
            String linea = "";
            ArrayList<String> lineas = new ArrayList<>();
            String url = System.getProperty("user.dir");

            try (Scanner sc = new Scanner(new File(nombreArchivo))) {
                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    lineas.add(linea);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            if (operacion == "A" || operacion == "D") {
                Collections.sort(lineas);
            } else {
                Collections.sort(lineas, String.CASE_INSENSITIVE_ORDER);
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(url + "\\ascendente.txt", false))) {
                if (operacion == "A" || operacion == "a") {
                    for (int i = 0; i < lineas.size(); i++) {
                        pw.write(lineas.get(i));
                        pw.println();
                    }
                } else {
                    for (int i = lineas.size() - 1; i >= 0; i--) {
                        pw.write(lineas.get(i));
                        pw.println();
                    }
                }
                



/* 
                if (operacion == "D" || operacion == "d") {
                    Collections.reverse(lineas);
                } 
                for (String s:lineas)pw.println(s);
   */                 













            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    public static void main(String[] args) {
        String nombre = "C:\\Users\\Monica\\Desktop\\equipoEmpresa.txt";
        ejercicio7(nombre, "D");
    }
}
