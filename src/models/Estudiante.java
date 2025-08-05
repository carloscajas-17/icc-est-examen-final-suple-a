package models;

import java.util.*;

public class Estudiante {
    private String nombre;
    private String cedula;
    private List<Double> calificaciones;
    private int porcentajeUnicos;

    public Estudiante(String nombreCompleto, String cedula, List<Double> calificaciones) {
        this.nombre = nombreCompleto;
        this.cedula = cedula;
        this.calificaciones = calificaciones;
        this.porcentajeUnicos = calcularPorcentajesUnicos();
    }

    public int getPromedio() {
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return (int) (suma / calificaciones.size());
    }

    private int calcularPorcentajesUnicos() {
        String sinEspacios = nombre.replaceAll("\\s+", "").toLowerCase();
        Set<Character> unicos = new HashSet<>();
        for (char c : sinEspacios.toCharArray()) {
            unicos.add(c);
        }
        return (int) ((unicos.size() * 100.0) / sinEspacios.length());
    }

    public int getPorcentajeUnicos() {
        return porcentajeUnicos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ") Porcentaje de caracteres únicos: " +
                porcentajeUnicos + "%, Promedio: " + getPromedio();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) obj;
        return this.cedula.equals(e.cedula);
    }

    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
}

