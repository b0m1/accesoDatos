import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // EJERCICIO1
        // SAXParserFactory factory = SAXParserFactory.newInstance();
        // SAXParser parser = factory.newSAXParser();
        // EjerciciosSAX parserSax = new EjerciciosSAX(); // ParserSAX es la clase que se deberá
        // parser.parse("C:\\Users\\Monica\\Desktop\\peliculas.xml", parserSax); // implementar y que hereda de DafaultHandler
        // ArrayList<Pelicula> list = parserSax.getPeliculas();

        // for (Pelicula pelicula : list) {
        // System.out.println("Titulo: " + pelicula.getTitulo());
        // System.out.println("Atributos: "+ pelicula.getGenero()+" "+pelicula.getYear()+" "+pelicula.getIdioma());
        // System.out.println("Director/es:");

        //     for (int i = 0; i < pelicula.getDirector().size(); i++) {
        //         System.out.printf("%s: %s\n",i%2==0? "nombre":"apellido" ,
        //         pelicula.getDirector().get(i));
        //     }

        // System.out.println("-----------------------------------------------------------------------------");

        // }

        // EJERCICIO 3
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        EjerciciosSAX parserSax = new EjerciciosSAX(); // ParserSAX es la clase que se deberá
        parser.parse("C:\\Users\\Monica\\Desktop\\peliculas.xml", parserSax); // implementar y que hereda de
                                                                              // DafaultHandler
        ArrayList<Pelicula> list = parserSax.getPeliculas();
        mostrarNDirectores(list, 2);
        

        //EJ4
        System.out.println(contarGeneros(list));
        
        
        // Ejercicio 2
        // SAXParserFactory factory = SAXParserFactory.newInstance();
        // SAXParser parser = factory.newSAXParser();
        // Ejercicio2SAX parserSax = new Ejercicio2SAX(); // ParserSAX es la clase que
        // se deberá
        // parser.parse("C:\\Users\\Monica\\Desktop\\peliculas.xml", parserSax); //
        // implementar y que hereda de DafaultHandler
    }
    static public void mostrarNDirectores (ArrayList<Pelicula> peliculas, int n){
        for (Pelicula pelicula: peliculas){
            if (pelicula.getDirector().size() >= n*2){
                System.out.println("Titulo: " + pelicula.getTitulo());
                System.out.println(
                        "Atributos: " + pelicula.getGenero() + " " + pelicula.getYear() + " " + pelicula.getIdioma());
                        System.out.println("Director/es:");
                         for (int i = 0; i < pelicula.getDirector().size(); i++) {
                            System.out.printf("%s: %s\n",i%2==0? "nombre":"apellido" ,
                            pelicula.getDirector().get(i));
                        }
                
                System.out.println("------------------------------------------------------------------");
            }
        }
    }
    static public int contarGeneros(ArrayList<Pelicula> peliculas){
        int numGeneros=0;
        String genero="";
        if(peliculas!=null && peliculas.size()>0){
           
            for (Pelicula pelicula : peliculas) {
                
                if (!genero.contains(pelicula.getGenero())){
                    numGeneros++;
                }
                genero+=pelicula.getGenero();
            }
        }
        return numGeneros;
        
    }
}
