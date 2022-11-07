public class Letras {
    int cantidad;
    char letra;
    public Letras(char letra) {
        this.cantidad = 1;
        this.letra = letra;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public char getLetra() {
        return letra;
    }
    public void setLetra(char letra) {
        this.letra = letra;
    }
    
}
