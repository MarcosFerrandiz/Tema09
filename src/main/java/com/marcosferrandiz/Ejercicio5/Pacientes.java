package com.marcosferrandiz.Ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Pacientes {
    private static int contadorId;
    private final int id;
    private final String nombre;
    private final LocalDate fechNac;
    private Genero genero;
    private double altura;
    private double peso;

    public Pacientes(String nombre, LocalDate fechNac, Genero genero, double altura, double peso) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.fechNac = fechNac;
        this.genero = (genero == Genero.M || genero == Genero.F) ? genero : Genero.M;
        this.altura = altura;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }
    public int getEdad(){
        return Period.between(fechNac, LocalDate.now()).getYears();
    }

    public Genero getGenero() {
        return genero;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacientes pacientes = (Pacientes) o;
        return id == pacientes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Edad: " + getEdad() + " Sexo: " + genero;
    }
}
