package com.marcosferrandiz.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empleados {
    private List<Hijos> hijos;
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechNac;
    private double sueldo;

    public Empleados(String dni, String nombre, String apellidos, LocalDate fechNac, double sueldo) {
        this.hijos = new ArrayList<>();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechNac = fechNac;
        this.sueldo = sueldo;
    }

    public List<Hijos> getHijos() {
        return hijos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getEdad(){
        return Period.between(fechNac,LocalDate.now()).getYears();
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void agragarHijo(Hijos hijo){
        hijos.add(hijo);
    }

    /**
     * Metodo que sirve para saber si un empleado tiene hjos menores
     * @return Devuelve true si si que tiene y false si no los tiene
     */
    public boolean tieneHijosMenores(){
        for (Hijos hijo : hijos){
            if (hijo.getEdad()<18){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para eliminar a un hijo de un empleado
     * @param nombreHijo Es el nombre del hijo que queremos eliminar
     * @return Devuelve true si se ha podido eliminar o false si no
     */
    public boolean eliminarHijo(String nombreHijo){
        for (Hijos hijo : hijos){
            if (hijo.getNombre().equalsIgnoreCase(nombreHijo)){
                hijos.remove(hijo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleados empleados = (Empleados) o;
        return Objects.equals(dni, empleados.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Detalles empleado ---\n")
                .append("NIF: ").append(getDni()).append("\n")
                .append("Nombre: ").append(getNombre()).append(" ")
                .append(getApellidos()).append("\n")
                .append("Edad: ").append(getEdad()).append("\n")
                .append("Sueldo: ").append(getSueldo()).append("\n")
                .append("Hijos: ").append(getHijos().size()).append("\n");
        for (Hijos hijo : getHijos()) {
            sb.append("  - ").append(hijo.getNombre())
                    .append(": ").append(hijo.getEdad())
                    .append(" años\n");
        }
        return sb.toString();
    }
}
