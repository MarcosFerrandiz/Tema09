package com.marcosferrandiz.Ejercicio10;

import java.util.List;

public class Vista {
    /**
     * Menu 1
     */
    public static void menuPrincipal(){
        System.out.println("*********************");
        System.out.println("* GESTIÓN EMPLEADOS *");
        System.out.println("*********************");
        System.out.println("1. Nuevo empleado");
        System.out.println("2. Nuevo hijo");
        System.out.println("3. Modificar sueldo");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Borrar hijo");
        System.out.println("6. Consultas");
        System.out.println("---------------------");
        System.out.println("0. Salir");
    }

    /**
     * Menu 2
     */
    public static void menuConsultas(){
        System.out.println("***********************");
        System.out.println("* CONSULTAS EMPLEADOS *");
        System.out.println("***********************");
        System.out.println("1. Buscar por NIF");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por rango de edad");
        System.out.println("4. Buscar por rango de sueldo");
        System.out.println("Buscar por hijos menores de edad");
        System.out.println("-----------------------");
        System.out.println("0. Salir al menú principal");
    }

    /**
     * Muestra toda la información de un empleado
     * @param empleado Es el empleado que queremos mostrar
     */
    public static void mostrarEmpleado(Empleados empleado) {
        System.out.println("\n--- Detalles empleado ---");
        System.out.println("NIF: " + empleado.getDni());
        System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellidos());
        System.out.println("Edad: " + empleado.getEdad());
        System.out.println("Sueldo: " + empleado.getSueldo());
        System.out.println("Hijos: " + empleado.getHijos().size());

        for (Hijos hijo : empleado.getHijos()) {
            System.out.println("  - " + hijo.getNombre() + " (" + hijo.getEdad() + " años)");
        }
    }

    /**
     * Muestra un List<Empelados> y todos los Empleados de esta
     * @param empleados Es la List<Empleados> que queremos mostrar
     */
    public static void mostrarListaEmpleados(List<Empleados> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No se encontraron empleados");
            return;
        }
        for (Empleados empleado : empleados) {
            mostrarEmpleado(empleado);
        }
    }
}
