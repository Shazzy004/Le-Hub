package logica;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Becas {
	private static final int MAX_ESTUDIANTES = 100;
    private static ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }

    public ArrayList<String> obtenerEstudiantesBecados() {
        ArrayList<String> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndice() >= 2.0) {
                estudiantesBecados.add(estudiante.getNombre());
            }
        }

        return estudiantesBecados;
    }
    
    public static ArrayList<Estudiantes> buscarPorCarreraYSexo(String carrera, String sexo) {
        return (ArrayList<Estudiantes>) estudiantes.stream()
                .filter(estudiante -> estudiante.getCarrera().equals(carrera) && estudiante.getSexo().equals(sexo))
                .collect(Collectors.toList());
    }

}
