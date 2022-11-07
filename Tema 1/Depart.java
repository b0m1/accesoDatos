import java.io.Serializable;

public class Depart implements Serializable{
    private String nombreDepart;
    private int numEmpleados;
    public void setNumEmpleados(int numEmpleados){
        this.numEmpleados = numEmpleados;
    }
    public int getNumEmpleados(){
        return numEmpleados;
    }
    public String getNombreDepart() {
        return nombreDepart;
    }
    public void setNombreDepart(String nombreDepart) {
        this.nombreDepart = nombreDepart.toUpperCase();
    }
    // public Persona[] getEmpleados() {
    //     return empleados;
    // }
    // public void setEmpleados(Persona[] empleados) {
    //     this.empleados = empleados;
    // }
    public Depart(String nombreDepart, int numEmpleados){
        this.nombreDepart=nombreDepart;
        this.numEmpleados =numEmpleados;
       
    }
    public Depart(){
        this.nombreDepart="";
        this.numEmpleados=2;
    
    }

}
