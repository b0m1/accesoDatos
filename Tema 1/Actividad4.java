import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Actividad4 {
    public static void letraMasUsada(File archivo) {
        ArrayList<Letras> coleccion = new ArrayList<>();

        try (FileReader fr = new FileReader(archivo)) {
            int cont = 0;
            int primeraLetra;
            int codigoLetra;
            char letra;

            primeraLetra = fr.read();
            letra = (char) primeraLetra;
            Letras nuevaLetra = new Letras(letra);
            coleccion.add(nuevaLetra);

            while ((codigoLetra = fr.read()) != -1) {
                cont = 0;
                letra = (char) codigoLetra;

                for (int i = 0; i < coleccion.size(); i++) {
                    if (letra == coleccion.get(i).getLetra()) {
                        coleccion.get(i).setCantidad(coleccion.get(i).getCantidad() + 1);
                        cont++;
                    }
                }
                if (cont == 0) {
                    Letras otraLetra = new Letras(letra);
                    coleccion.add(otraLetra);
                }
            }

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        // comprobar que la coleccion no esté vacia? y el fichero=?
        if(!coleccion.isEmpty()){
            int acu = 0;
            String letra="";
            
            for (int i = 0; i < coleccion.size(); i++) {
                if (coleccion.get(i).getCantidad() > acu) {
                    String obtenerletra;
                    acu = coleccion.get(i).getCantidad();
                    obtenerletra = String.valueOf(coleccion.get(i).getLetra());
                    letra = obtenerletra;
                }
            }
            System.out.println(letra + " - " + acu);
        }
        
    }

    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Monica\\Desktop\\texto.txt");
        letraMasUsada(archivo);

    }
}
