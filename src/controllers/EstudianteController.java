package controllers;

import models.Estudiante;

import java.util.*;

public class EstudianteController {

    public Set<Estudiante> ordenarPorPromedio(List<Estudiante> estudiantes) {
        Set<Estudiante> conjunto = new TreeSet<>(new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                int cmpProm = Integer.compare(e2.getPromedio(), e1.getPromedio());
                if (cmpProm != 0) return cmpProm;
                int cmpNom = e1.getNombre().compareTo(e2.getNombre());
                if (cmpNom != 0) return cmpNom;
                return e1.getCedula().compareTo(e2.getCedula());
            }
        });
        conjunto.addAll(estudiantes);
        return conjunto;
    }

    public Map<String, List<Estudiante>> clasificarPorPorcentaje(Set<Estudiante> ordenados) {
        Map<String, List<Estudiante>> clasificados = new LinkedHashMap<>();
        clasificados.put("A", new LinkedList<>());
        clasificados.put("B", new LinkedList<>());
        clasificados.put("C", new LinkedList<>());
        clasificados.put("D", new LinkedList<>());
        clasificados.put("E", new LinkedList<>());

        for (Estudiante e : ordenados) {
            int p = e.getPorcentajeUnicos();
            if (p >= 90) clasificados.get("A").add(e);
            else if (p >= 70) clasificados.get("B").add(e);
            else if (p >= 50) clasificados.get("C").add(e);
            else if (p >= 30) clasificados.get("D").add(e);
            else clasificados.get("E").add(e);
        }

        return clasificados;
    }

    public List<Estudiante> obtenerEstudiantesDestacados(List<Estudiante> lista) {
        List<Estudiante> destacados = new ArrayList<>();
        for (Estudiante e : lista) {
            if (e.getPromedio() > 7) {
                destacados.add(e);
            }
        }
        destacados.sort(Comparator.comparing(Estudiante::getNombre));
        return destacados;
    }

    public Estudiante buscarPorNombre(List<Estudiante> lista, String nombre) {
        int izquierda = 0;
        int derecha = lista.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Estudiante medioEst = lista.get(medio);
            int comparacion = medioEst.getNombre().compareTo(nombre);

            if (comparacion == 0) {
                return medioEst;
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }
}


