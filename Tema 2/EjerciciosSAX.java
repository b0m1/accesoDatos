import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class EjerciciosSAX extends DefaultHandler {
    private Pelicula currentPelicula = new Pelicula();
    public ArrayList<Pelicula> peliculas = new ArrayList<>();
    int numDirectores=0;
    boolean titulo, nombre, apellido = false;

    ArrayList<String> directores = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("pelicula")) {
            numDirectores=0;
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getLocalName(i).equals("genero")) {
                    currentPelicula.setGenero(attributes.getValue(i));
                } else {
                    if (attributes.getLocalName(i).equals("año")) {
                        currentPelicula.setYear(Integer.parseInt(attributes.getValue(i)));
                    } else {
                        if (attributes.getLocalName(i).equals("idioma")) {
                            currentPelicula.setIdioma(attributes.getValue(i));
                        }
                    }
                }
            }

            // else if (this.qName.equals("apellido"))
            // apellido=true;
            // // else if (this.qName.equals("director"))
            // // currentPelicula.setDirector(cad);

        }
        if (qName.equalsIgnoreCase("titulo"))
            titulo = true;
        else if(qName.equals("director"))
            numDirectores++;
        else if (qName.equals("nombre"))
            nombre = true;
            else if(qName.equals("apellido"))
            apellido =true;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
         String cad = new String(ch, start, length);
        if (titulo) {
            currentPelicula.setTitulo(cad);
            titulo = false;
        }
        if (nombre) {

            directores.add(cad);
            nombre=false;
        }
        if (apellido) {

            directores.add(cad);
            apellido=false;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Aviso: " + e.getMessage());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO Auto-generated method stub

        if(qName.equals("director")){
            
        }
        if (qName.equals("pelicula")) {
            currentPelicula.setDirector(directores);
            directores = new ArrayList<>();
            peliculas.add(currentPelicula);
            currentPelicula = new Pelicula();
        }
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
}
