
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejercicio2SAX extends DefaultHandler {

  boolean titulo, nombre, apellido = false;
  String tab = "	";
	String tab2 = "		";
	String tab3 ="			";

  @Override
  public void startDocument() throws SAXException {
    System.out.println("Comienzo a leer");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equals("filmoteca")) {
      System.out.println("<filmoteca>");
    } else if (qName.equals("pelicula")) {

      System.out.println(tab + "<pelicula>");
    } else if (qName.equals("titulo")) {
      System.out.print(tab2 + "<titulo>");
      titulo = true;
    } else if (qName.equals("director")) {

      System.out.println(tab2 + "<director>");
    } else if (qName.equals("nombre")) {
      System.out.print(tab3 + "<nombre>");
      nombre = true;
    }
		else if (qName.equals("apellido")) {
      System.out.print(tab3 + "<apellido>");
      apellido = true;
    }

  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    String cad = new String(ch, start, length);
    if (titulo) {
      System.out.print(cad);
      titulo = false;
    }
    if (nombre) {
      System.out.print(cad);
      nombre = false;
    }
		if (apellido) {
      System.out.print(cad);
      apellido = false;
    }

  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals("filmoteca")) {
      System.out.println("</filmoteca>");
    }
    if (qName.equals("pelicula")) {
      System.out.println(tab + "</pelicula>");

    }
    if (qName.equals("titulo")) {
      System.out.print("</titulo>\n");
    }
    if (qName.equals("director")) {
      System.out.println(tab2+"</director>");
    }
    if (qName.equals("nombre")) {
      System.out.print("</nombre>\n");
    }
		if (qName.equals("apellido")) {
      System.out.print("</apellido>\n");
    }
  }

  @Override
  public void endDocument() throws SAXException {
    System.out.println("Fin documento");
  }
}
