
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad9 {
    static void guardarDatos(File archivo, int codigo, String nombre, double altura) {
        try (FileOutputStream fos = new FileOutputStream(archivo, true)) {
            DataOutputStream out = new DataOutputStream(fos);
            out.writeInt(codigo);
            out.writeUTF(nombre);
            out.writeDouble(altura);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    static void leerDatos(String url) {
        
        try (FileInputStream fin = new FileInputStream(url)) {
            DataInputStream in = new DataInputStream(fin);
            while (true) {
                
                System.out.printf("%d, %s, %.2f\n", in.readInt(), in.readUTF(), in.readDouble());            
            }
            
        } catch(EOFException e){
            System.err.println("Fin archivo");
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
    static void guardarArchivoTemporal(int codigoBorrar, File archivoTemporal){
        String url = System.getProperty("user.home");
        try (FileInputStream fin = new FileInputStream(url+"\\alumnos.dat");FileOutputStream fout= new FileOutputStream(archivoTemporal)) {
            DataInputStream in = new DataInputStream(fin);
            DataOutputStream out = new DataOutputStream(fout);
            while (true) { 
                int codigo = in.readInt();  
                String nombre = in.readUTF();
                double altura = in.readDouble();
                if(codigo!=codigoBorrar){
                    out.writeInt(codigo);
                    out.writeUTF(nombre);
                    out.writeDouble(altura);
                }
            }
            
        } catch(EOFException e){
            System.err.println("Fin archivo");
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

                    
    }
    static boolean comprobarCodigo(int codigo){
        String url = System.getProperty("user.home");
        try (FileInputStream fin = new FileInputStream(url+"\\alumnos.dat")) {
            DataInputStream in = new DataInputStream(fin);
            while (true) {
                if(codigo == in.readInt()){
                    return false;
                } 
                 in.readUTF();
                 in.readDouble();
            }
            
        } catch(EOFException e){
            System.err.println("Fin archivo");
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return true;
    }
    static void menu() {
        boolean error;
        int opcion = 0;
        String url = System.getProperty("user.home");
        File archivo = new File(url+"\\alumnos.dat");
        do {
            try {
                error = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Menú de opciones.");
                System.out.println("1. Dar de alta nuevos alumnos");
                System.out.println("2. Consultar alumnos");
                System.out.println("3. Modificar alumnos");
                System.out.println("4. Borrar alumnos");
                System.out.println("5. Salir");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el código: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        if(!comprobarCodigo(codigo)){
                            System.out.println("código duplicado");
                            break;
                        }
                        System.out.println("Introduce el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce la altura: ");
                        double altura = sc.nextDouble();
                        
                        guardarDatos(archivo, codigo, nombre, altura);

                        break;
                    case 2:
                        leerDatos(url+"\\alumnos.dat");
                        break;
                    case 3:
                        //TODO 

                        break;
                    case 4:
                        System.out.println("Introduce el código: ");
                        codigo = sc.nextInt();
                        File archivoTemp = new File(url+"\\alumnos2.dat");
                        guardarArchivoTemporal(codigo, archivoTemp);
                        Actividad8.copiarArchivoBinario(archivoTemp, new File(url+"\\alumnos.dat"));
                        
                        break;
                    case 5:

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("El carácter introducido no es válido");
                error = true;
            }
        } while (error || opcion != 5);
    }
    public static void main(String[] args) {
        menu();
    }
}
