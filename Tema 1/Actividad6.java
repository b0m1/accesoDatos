import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Actividad6 {
    //parametro file 
    public static void unirArchivos(File[] archivos, File archivoDestino) {
        String contenidoArchivo="";
        try (PrintWriter fout = new PrintWriter(new FileWriter(archivoDestino, true))) {
            for (int i = 0; i < archivos.length; i++) {
                try (Scanner sc = new Scanner(archivos[i])) {
                    while (sc.hasNext()) {
                        contenidoArchivo+=sc.nextLine();
                    }
                    fout.write(contenidoArchivo);
                } catch (Exception e) {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void dividirArchivoLineas(File archivo, int l) {
        int numLineas = 0;
        int cont = 0;
        String lineas = "";
        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                numLineas++;
                lineas = sc.nextLine();
                if (numLineas == l) {
                    cont++;
                    try (PrintWriter fout = new PrintWriter("C:\\Users\\Monica\\Desktop\\new" + cont + ".txt")) {
                        fout.write(lineas);
                    } catch (Exception e) {
                        System.err.println(e.getLocalizedMessage());
                    }
                    lineas = "";
                    numLineas = 0;
                }
            }

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
    // Quitar arraylist
    public static void dividirArchivo(File archivo, int n) {
        ArrayList<String> coleccion = new ArrayList<>();
        int cont = 0;
        int letraCodigo;
        char letra = ' ';
        String rellenar = "";

        try (FileReader fr = new FileReader(archivo)) {
            while ((letraCodigo = fr.read()) != -1) {
                cont++;
                letra = (char) letraCodigo;
                rellenar += letra;
                if (cont == n) {
                    coleccion.add(rellenar);
                    rellenar = "";
                    cont = 0;
                }
            }

            for (int i = 0; i < coleccion.size(); i++) {
                try (PrintWriter fout = new PrintWriter("C:\\Users\\Monica\\Desktop\\new" + i + ".txt")) {
                    fout.write(coleccion.get(i));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        //File archivo = new File("C:\\Users\\Monica\\Desktop\\equipoEmpresa.txt");
        //dividirArchivoLineas(archivo, 1);
        File destino = new File("C:\\Users\\Monica\\Desktop\\oa.txt");
        File[] archivos = new File[2];
        archivos[0]= new File("C:\\Users\\Monica\\Desktop\\equipoEmpresa.txt");
        archivos[1]= new File("C:\\Users\\Monica\\Desktop\\texto.txt");
        unirArchivos(archivos, destino);


    }
}