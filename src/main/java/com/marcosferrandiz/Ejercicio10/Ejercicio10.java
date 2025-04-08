package com.marcosferrandiz.Ejercicio10;


import com.github.javafaker.Faker;
import com.marcosferrandiz.lib.Aleatorios;
import com.marcosferrandiz.lib.SolicitarCosas;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Ejercicio10 {
    public static Gestion gestion = new Gestion();
    public static Faker faker = new Faker(new Locale("es"));
    public static void main(String[] args) {

        generarDatosParaProbar(8);

        int deci;
        do {
            Vista.menuPrincipal();
            deci = SolicitarCosas.solicitarEntero("Introduzca la opción deseada",0,6);

            switch (deci){
                case 1 ->{
                    crearEmpleado();
                    break;
                }
                case 2 ->{
                    agragarHijo();
                    break;
                }
                case 3 ->{
                    modificarSueldo();
                    break;
                }
                case 4 ->{
                    borrarEmpleado();
                    break;
                }
                case 5 ->{
                    borrarHijo();
                    break;
                }
                case 6 ->{
                    Vista.menuConsultas();
                    switchSubMenu();
                }
                default ->{
                    System.out.println("Saliendo...");
                    break;
                }
            }

        }while (deci != 0);
    }

    /**
     * Es el switch del submenu de consultas
     */
    public static void switchSubMenu(){
        int deci2 = SolicitarCosas.solicitarEntero("Introduzca la opción deseada",0,5);
        switch (deci2){
            case 1->{
                consultarPorDNI();
                break;
            }
            case 2->{
                consultarPorNombre();
                break;
            }
            case 3->{
                consultarPorRangoEdad();
                break;
            }
            case 4->{
                consultarPorRangoSueldo();
                break;
            }
            case 5->{
                consultarPorHijosMenores();
                break;
            }
            default->{return;}
        }
    }

    /**
     * Genera datos con faker la cantidad de veces que se le indique
     * @param cantidad La cantidad de datos que queremos que cree
     */
    public static void generarDatosParaProbar(int cantidad){
        for (int i = 0; i < cantidad ; i++) {
            Empleados empleado = crearEmpleadoMentiroso();
            gestion.agragarEmpleado(empleado);
            int numeroHijos = Aleatorios.aleatorio(0,5);
            for (int j = 0; j < numeroHijos ; j++) {
                gestion.agragarHijo(empleado.getDni(),crearHijoMentirosoConUnClic());
            }
        }
    }

    /**
     * Genera una fecha de nacimiento de forma aleatoria
     * @param minEdad Es la edad minima que queremos crear
     * @param maxEdad Es la edad maxima que queremos crear
     * @return Devuelve una fecha LocalDate de la fecha de nacimiento
     */
    public static LocalDate generarFechaAleatoria(int minEdad, int maxEdad) {
        if (minEdad < 0 || maxEdad < 0 || minEdad > maxEdad) {
            System.err.println("Rando de edad no valido");
        }
        int edad = Aleatorios.aleatorio(minEdad,maxEdad);
        int añoActual = LocalDate.now().getYear();
        int añoNacimiento = añoActual - edad;
        int mes = Aleatorios.aleatorio(1,12);
        int dia = Aleatorios.aleatorio(1,28);
        return LocalDate.of(añoNacimiento, mes, dia);
    }

    /**
     * Crea un empleado nuevo completamente con faker
     * @return Devuelve un Empleado creado de forma aleatoria
     */
    public static Empleados crearEmpleadoMentiroso(){
        return new Empleados(generarDNI(),faker.name().firstName(),faker.name().lastName(),generarFechaAleatoria(25,100), faker.number().randomDouble(2,900,2000));
    }

    /**
     * Crea un hijo de forma aleatoria con nombre de personajes de dragon ball porque si
     * @return Devuelve un nuevo hijo
     */
    public static Hijos crearHijoMentirosoConUnClic(){
        return new Hijos(faker.dragonBall().character(), generarFechaAleatoria(0,17));
    }

    /**
     * Genera un DNI aleatorio
     * @return Devuelve el DNI generado
     */
    public static String generarDNI() {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = faker.number().numberBetween(10000000, 99999999);
        char letra = letras.charAt(numero % 23);
        return numero + "" + letra;
    }


    /*------------------------------------------------------------------------------------------------------------------*/


    /**
     * Metodo que se encarga de poder crear un nuevo empleado
     */
    public static void crearEmpleado(){
        String dni = SolicitarCosas.solicitarString("Ponga su DNI",9,9);
        String nombre = SolicitarCosas.solicitarStringSinLimite("Introduzca su nombre");
        String apellido = SolicitarCosas.solicitarStringSinLimite("Introduzca su apellido");
        LocalDate fechNac = SolicitarCosas.solicitarFecha("Introduzca la fehca de nacimiento","dd-MM-yyyy");
        double sueldo = SolicitarCosas.solicitarDoubleConMinimo("Introduzca su sueldo",900);
        Empleados empleado = new Empleados(dni,nombre,apellido,fechNac,sueldo);

        if (gestion.agragarEmpleado(empleado)){
            System.out.println("El empleado se ha creado correctamente");
        }
        else {
            System.err.println("El empleado ya existe");
        }
    }

    /**
     * Metodo para agragar un nuevo hijo a un Empleado mediante su DNI
     */
    public static void agragarHijo(){
        String dni = SolicitarCosas.solicitarString("Ponga su DNI",9,9);
        String nombre = SolicitarCosas.solicitarStringSinLimite("Introduzca el nombre del hijo");
        LocalDate fechNac = SolicitarCosas.solicitarFecha("Introduzca la fehca de nacimiento","dd-MM-yyyy");
        Hijos hijo = new Hijos(nombre,fechNac);
        gestion.agragarHijo(dni,hijo);
        System.out.println("El hijo se a agragado correctamente");
    }

    /**
     * Metodo para modificar el sueldo de un empleado
     */
    public static void modificarSueldo(){
        String dni = SolicitarCosas.solicitarString("Ponga su DNI",9,9);
        double sueldo = SolicitarCosas.solicitarDoubleConMinimo("Introduzca su sueldo",900);
        if (gestion.modificarSueldo(dni,sueldo)){
            System.out.println("El sueldo ha sido cambiado, esperemos que a bien y no ha mal");
        }
        else {
            System.err.println("No se ha encontrado el empleado");
        }
    }

    /**
     * Metodo para borrar un Empleado del programa
     */
    public static void borrarEmpleado(){
        String dni = SolicitarCosas.solicitarString("Ponga su DNI",9,9);
        if (gestion.eliminarEmpleado(dni)){
            System.out.println("Empleado a tomar por saco");
        }
        else {
            System.err.println("No se ha encontrado ningún empleado");
        }
    }

    /**
     * Metodo que sirve para borrar un hijo de un empleado
     */
    public static void borrarHijo(){
        String dni = SolicitarCosas.solicitarString("Ponga su DNI",9,9);
        String nombre = SolicitarCosas.solicitarStringSinLimite("Introduzca el nombre del hijo");
        if (gestion.eliminarHijo(dni,nombre)){
            System.out.println("A tomar por saco el hijo, le han tirado pocion de veneno 2");
        }
        else {
            System.err.println("Una de dos, o no se encuentra el empleado o el hijo, o ambas, quien sabe");
        }
    }

    /**
     * Metodo de consultar por DNI y que muestre por pantalla el empleado
     */
    public static void consultarPorDNI(){
        Empleados empleado = gestion.buscarPorDNI(SolicitarCosas.solicitarString("Ponga su DNI",9,9));
        if (empleado != null){
            Vista.mostrarEmpleado(empleado);
        }
        else {
            System.err.println("El empleado no se ha encontrado");
        }
    }

    /**
     * Metodo para consultar por nombre y muestra todos los Empleados con ese nombre y su informacion
     */
    public static void consultarPorNombre(){
        List<Empleados> resultadoNombres = gestion.buscarPorNombre(SolicitarCosas.solicitarStringSinLimite("Introduzca el nombre"));
        Vista.mostrarListaEmpleados(resultadoNombres);
    }

    /**
     * Metodo para consultar empleados por un rango de sueldo y muestra todos los Empleados cuyo sueldo esta en ese rango
     */
    private static void consultarPorRangoSueldo(){
        double min = SolicitarCosas.solicitarDoubleConMinimo("Introduzca el sueldo mínimo",0);
        double max = SolicitarCosas.solicitarDoubleConMinimo("Introduzca el sueldo max",min);
        List<Empleados> resultadoSueldo = gestion.buscarPorRangoDeSueldo(min,max);
        Vista.mostrarListaEmpleados(resultadoSueldo);
    }

    /**
     * Metodo para consultar todos los Empleados dentro de un rango de edad y mostrarlos por pantalla
     */
    private static void consultarPorRangoEdad(){
        int min = SolicitarCosas.solicitarInt("Introduzca el sueldo mínimo",0);
        int max = SolicitarCosas.solicitarInt("Introduzca el sueldo max",min);
        List<Empleados> resultadoEdad = gestion.buscarPorRangoDeEdad(min,max);
        Vista.mostrarListaEmpleados(resultadoEdad);
    }

    /**
     * Metodo que muestra todos los Empleados que tengan hijos menores
     */
    private static void consultarPorHijosMenores(){
        List<Empleados> resultadoHijos = gestion.buscarPorHijosMenores();
        Vista.mostrarListaEmpleados(resultadoHijos);
    }
}
