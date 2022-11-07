import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

class Ejercicio1 {
    public void grabarDOM(Document document, String ficheroSalida)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, FileNotFoundException {
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS ls = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
        // Se crea un destino vacio
        LSOutput output = ls.createLSOutput();
        output.setEncoding("UTF-8");
        // Se establece el flujo de salida
        output.setByteStream(new FileOutputStream(ficheroSalida));
        // output.setByteStream(System.out);
        // Permite escribir un documento DOM en XML
        LSSerializer serializer = ls.createLSSerializer();
        // Se establecen las propiedades del serializador
        serializer.setNewLine("\r\n");
        ;
        serializer.getDomConfig().setParameter("format-pretty-print", true);
        // Se escribe el documento ya sea en un fichero o en una cadena de texto
        serializer.write(document, output);
        // String xmlCad=serializer.writeToString(document);
    }

    public Document crearArbol(String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            System.out.println("Error generando el árbol DOM: " + e.getMessage());
        }
        return doc;
    }

    public void verTitulos(Document doc) {
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }

    public void getNumAtributos(Document doc) {
        NodeList pelis = doc.getElementsByTagName("pelicula");
        ArrayList<String> generos = new ArrayList<>();
        for (int i = 0; i < pelis.getLength(); i++) {
            Element peli = (Element) pelis.item(i);
            if (!generos.contains(peli.getAttribute("genero"))) {
                generos.add(peli.getAttribute("genero"));
            }
        }
        System.out.println("Hay " + generos.size() + " géneros distintos. Son:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println(generos.get(i));
        }
    }

    public void getPeliculaSegunDirector(Document doc, int directores) {
        NodeList pelis = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < pelis.getLength(); i++) {
            Element peli = (Element) pelis.item(i);
            NodeList titulos = peli.getElementsByTagName("titulo");
            NodeList director = peli.getElementsByTagName("director");

            if (director.getLength() > directores) {
                System.out.println("------");
                if (titulos.getLength() > 0) {
                    System.out.println(titulos.item(0).getFirstChild().getNodeValue());
                }
                for (int j = 0; j < director.getLength(); j++) {
                    NodeList nombre = ((Element) director.item(j)).getElementsByTagName("nombre");
                    NodeList apellidos = ((Element) director.item(j)).getElementsByTagName("apellido");
                    if (nombre.getLength() > 0) {
                        System.out.println(nombre.item(0).getFirstChild().getNodeValue());
                    }
                    if (apellidos.getLength() > 0) {
                        System.out.println(apellidos.item(0).getFirstChild().getNodeValue());
                    }
                }
            }

        }
    }

    public void getDatos(Document doc) {
        NodeList pelis = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < pelis.getLength(); i++) {
            Element peli = (Element) pelis.item(i);
            System.out.println("------");
            NodeList titulos = peli.getElementsByTagName("titulo");
            if (titulos.getLength() > 0) {
                System.out.println(titulos.item(0).getFirstChild().getNodeValue());
            }

            NodeList director = peli.getElementsByTagName("director");

            for (int j = 0; j < director.getLength(); j++) {
                NodeList nombre = ((Element) director.item(j)).getElementsByTagName("nombre");
                NodeList apellidos = ((Element) director.item(j)).getElementsByTagName("apellido");
                if (nombre.getLength() > 0) {
                    System.out.println(nombre.item(0).getFirstChild().getNodeValue());
                }
                if (apellidos.getLength() > 0) {
                    System.out.println(apellidos.item(0).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public void addAtributo(Document doc, String titulo) {
        boolean existe = false;
        NodeList pelis = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < pelis.getLength(); i++) {
            Element peli = (Element) pelis.item(i);
            NodeList titulos = peli.getElementsByTagName("titulo");
            for (int j = 0; j < titulos.getLength(); j++) {
                if (titulos.item(0).getFirstChild().getNodeValue().equals(titulo)) {
                    existe = true;
                    // borrar
                }
            }

        }
        if (!existe) {
            // se crea un nodo película que contendrá los demás
            // elementos: titulo, director y estreno
            Element nodoPelicula = doc.createElement("pelicula");
            // Se añade a película un nodo tipo texto con un salto de línea (\n) para que
            // al abrirlo con un editor de texto cada nodo salga en un línea diferente.
            nodoPelicula.appendChild(doc.createTextNode("\n"));
            // Para titulo
            Element nodoTitulo = doc.createElement("titulo");
            Text textNodoTitulo = doc.createTextNode(titulo);
            nodoTitulo.appendChild(textNodoTitulo);
            nodoPelicula.appendChild(nodoTitulo);
            // Se añade también un nodo text con un saldo de línea \n
            nodoPelicula.appendChild(doc.createTextNode("\n"));

            // Se añade la película a películas, que es el primer nodo del documento
            Node raiz = doc.getFirstChild();
            raiz.appendChild(nodoPelicula);

        }
    }

    public void verConAtributo(Document doc) {
        NodeList pelis = doc.getElementsByTagName("pelicula");
        for (int i = 0; i < pelis.getLength(); i++) {
            Element peli = (Element) pelis.item(i);
            System.out.println("---------");
            NodeList titulos = peli.getElementsByTagName("titulo");
            if (titulos.getLength() > 0) {
                System.out.println(titulos.item(0).getFirstChild().getNodeValue());
            }
            if (peli.hasAttribute("año")) {
                System.out.print("Año: " + peli.getAttribute("año"));
            }
            if (peli.hasAttribute("genero")) {
                System.out.print(" - Género: " + peli.getAttribute("genero"));
            }
            if (peli.hasAttribute("idioma")) {
                System.out.println(" - Idioma: " + peli.getAttribute("idioma"));
            }
            NodeList director = peli.getElementsByTagName("director");
            for (int j = 0; j < director.getLength(); j++) {
                NodeList nombre = ((Element) director.item(j)).getElementsByTagName("nombre");
                NodeList apellidos = ((Element) director.item(j)).getElementsByTagName("apellido");
                if (nombre.getLength() > 0) {
                    System.out.println(nombre.item(0).getFirstChild().getNodeValue());
                }
                if (apellidos.getLength() > 0) {
                    System.out.println(apellidos.item(0).getFirstChild().getNodeValue());
                }
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio1 e1 = new Ejercicio1();
        Document doc = e1.crearArbol("C:\\Users\\Monica\\Desktop\\peliculas.xml");
        // e1.getNumAtributos(doc);
        e1.getDatos(doc);
        // e1.getPeliculaSegunDirector(doc, 1);
        // e1.verConAtributo(doc);
        e1.addAtributo(doc, "Depredador");
        try {
            e1.grabarDOM(doc, "pelicola2.xml");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}