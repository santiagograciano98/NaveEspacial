package co.edu.udea.naveespacial;

public class Persona {

    private String nombre;
    private int edad;
    private boolean estado;

    public Persona() {
    }

    public Persona(String nombre, int edad, boolean estado) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", estado=" + estado + '}';
    }

    
}
