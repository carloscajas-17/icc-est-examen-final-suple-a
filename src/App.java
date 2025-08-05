import controllers.EstudianteController;
import models.Estudiante;

import java.util.*;

public class App {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = Arrays.asList(
            new Estudiante("Ana Torres", "0101010101", Arrays.asList(8.5, 9.0, 7.5, 10.0, 9.5, 8.0)),
            new Estudiante("Luis Luis", "0202020202", Arrays.asList(6.0, 7.5, 8.0, 6.5, 7.0, 6.0)),
            new Estudiante("Camila Vera", "0303030303", Arrays.asList(10.0, 10.0, 10.0, 9.5, 9.0, 9.5)),
            new Estudiante("Marco Luis Luis", "0202020202", Arrays.asList(8.0, 7.5, 9.0, 8.5, 7.0, 8.0)),
            new Estudiante("Elena Ruiz", "0404040404", Arrays.asList(5.0, 1.0, 4.5, 6.0, 5.5, 6.5)),
            new Estudiante("Carlos Díaz", "0505050505", Arrays.asList(9.5, 1.0, 3.5, 10.0, 10.0, 10.0)),
            new Estudiante("Luis  Luis Luis Luis", "0606060606", Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
            new Estudiante("Luis  Luis Luis Luis", "0606060602", Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
            new Estudiante("Luis  Luis Luis Luis", "0606060603", Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
            new Estudiante("Luis  Luis Luis Luis", "0606060604", Arrays.asList(1.0, 2.0, 7.0, 3.0, 7.0, 7.0)),
            new Estudiante("Luis  Luis Luis Luis", "0606060605", Arrays.asList(5.0, 2.0, 7.0, 5.0, 7.0, 7.0))
        );

        EstudianteController controller = new EstudianteController();

        Set<Estudiante> ordenados = controller.ordenarPorPromedio(estudiantes);
        System.out.println("=== Estudiantes ordenados ===");
        int i = 1;
        for (Estudiante e : ordenados) {
            System.out.println(i++ + ".- " + e);
        }

        Map<String, List<Estudiante>> clasificados = controller.clasificarPorPorcentaje(ordenados);
        System.out.println("\n=== Clasificación por porcentaje de caracteres únicos ===");
        for (String categoria : clasificados.keySet()) {
            System.out.println("Categoría " + categoria + ":");
            for (Estudiante e : clasificados.get(categoria)) {
                System.out.println("  - " + e.getNombre() + ";");
            }
        }

        List<Estudiante> destacados = controller.obtenerEstudiantesDestacados(estudiantes);
        System.out.println("\n=== Estudiantes destacados (promedio > 7) ===");
        for (Estudiante e : destacados) {
            System.out.println("- " + e.getNombre());
        }

        String nombreBuscar = "Camila Vera";
        Estudiante encontrado = controller.buscarPorNombre(destacados, nombreBuscar);
        System.out.println("\n=== Estudiante buscado por nombre \"" + nombreBuscar + "\" ===");
        if (encontrado != null) {
            System.out.println("Estudiante encontrado: " + encontrado);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}

