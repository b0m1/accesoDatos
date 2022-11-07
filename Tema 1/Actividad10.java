import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Actividad10 {
    public static void guardarObjeto(File archivo, Object objeto) {
        ObjectOutputStream out=null;
        try (FileOutputStream fos = new FileOutputStream(archivo, true)) {
            if (archivo.length()==0) {
                out = new ObjectOutputStream(fos);
            }else{
                out = new AppendingObjectOutputStream(fos);
            } 
            out.writeObject(objeto);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    public static void leerDatos(File archivo) {
        try (FileInputStream fin = new FileInputStream(archivo); ObjectInputStream in = new ObjectInputStream(fin)) {

            Depart d;
            Persona p;
            while (true) {
                Object o = in.readObject();
                if (o.getClass().equals(Persona.class)) {
                    p = (Persona)o;
                    
                    System.out.printf("Nombre: %s DNI: %s Edad: %d" + "\n", p.getNombre(), p.getDni(),
                            p.getEdad());
                } else {
                    if (o instanceof Depart) {
                        d = (Depart)o;
                        System.out.printf("Departamento: %s Num Empleados: %s" + "\n", d.getNombreDepart(),
                                d.getNumEmpleados());
                    }
                }

            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void copiarDatos(File archivo, File archivoDestino) {
        try (FileInputStream fin = new FileInputStream(archivo) ) {
            FileOutputStream fos = new FileOutputStream(archivoDestino);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            ObjectInputStream in = new ObjectInputStream(fin);
            
            while (true) {
                Object o = in.readObject();
                out.writeObject(o);
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }
    

    public static void main(String[] args) {
        Persona p2 = new Persona("monicaº","45454554M", 10);
        Depart d = new Depart("test", 2);
        Persona persona = new Persona("ISabel", "48206004M", 80);
        File archivo = new File("C:\\Users\\Monica\\Desktop\\objeto.txt");
        guardarObjeto(archivo, p2);
        File archivoD = new File("C:\\Users\\Monica\\Desktop\\objeto2.txt");
        leerDatos( archivoD);
    }

}
