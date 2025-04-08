package com.marcosferrandiz.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class Hijos {
    private final String nombre;
    private final LocalDate fechNac;

    public Hijos(String nombre, LocalDate fechNac) {
        this.nombre = nombre;
        this.fechNac = fechNac;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public int getEdad(){
        return Period.between(fechNac,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Hijos{" +
                "nombre='" + nombre + '\'' +
                ", fechNac=" + fechNac +
                '}';
    }
}
