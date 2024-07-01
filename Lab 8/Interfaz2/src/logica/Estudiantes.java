package logica;

public class Estudiantes {
    private String nombre;
    private String cedula;
    private String carrera;
    private String sexo;
    private double indice;

    public Estudiantes(String nombre, String cedula, String carrera, String sexo, double indice) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carrera = carrera;
        this.sexo = sexo;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSexo() {
        return sexo;
    }

    public double getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cédula: " + cedula + ", Carrera: " + carrera + ", Sexo: " + sexo + ", Índice: " + indice;
    }
}
