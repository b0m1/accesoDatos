import java.io.File;

public class Actividad2 {
    public void findDir(File directorio) {
        // if(directorio.isDirectory()){
        for (int i = 0; i < directorio.listFiles().length; i++) {
            System.out.println(directorio.listFiles()[i].getAbsolutePath());
            if (directorio.listFiles()[i].isDirectory()) {
                findDir(directorio.listFiles()[i]);
            }
            
        }
        // }
    }

    public static void main(String[] args) {
        Actividad2 a2 = new Actividad2();
        File test = new File("C:\\Users\\Mónica\\Desktop");
        a2.findDir(test);
    }
}
