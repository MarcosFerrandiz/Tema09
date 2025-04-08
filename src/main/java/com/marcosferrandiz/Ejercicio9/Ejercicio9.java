package com.marcosferrandiz.Ejercicio9;

import com.marcosferrandiz.lib.SolicitarCosas;

public class Ejercicio9 {
    private static Gestion gestion = new Gestion();
    public static void main(String[] args) {
        gestion.anadirPalabra("casa", "Lugar donde vive una persona o familia.");
        gestion.anadirPalabra("tele", "Forma abreviada de 'televisión', aparato para ver imágenes y sonido.");
        gestion.anadirPalabra("coche", "Vehículo con motor utilizado para transporte personal.");
        int deci;
        do {
            Vista.mostrarMenu();
            deci = SolicitarCosas.solicitarEntero("Seleccione una opción",0,7);
            switch (deci){
                case 1 ->{
                    anadirPalabra();
                    break;
                }
                case 2 ->{
                    modificarPalabra();
                    break;
                }
                case 3 ->{
                    borrarPalabra();
                    break;
                }
                case 4 ->{
                    consultarPalabra();
                    break;
                }
                case 5 ->{
                    Vista.mostrarDiccionario(gestion.getDiccionario());
                    break;
                }
                case 6 ->{
                    jugar();
                    break;
                }
                case 7 ->{
                    Vista.mostrarTopPuntuaciones(gestion.getMejoresPuntuaciones());
                }
                default -> {
                    System.out.println("Saliendo...");
                    break;
                }

            }
        }while (deci != 0);
    }

    /**
     * Añade una nueva palabra al diccionario
     */
    public static void anadirPalabra(){
        String palabraK = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra a añadir");
        if (gestion.getDefinicion(palabraK) != null){
            System.err.println("La palabra ya esta en el diccionario");
        }
        else  {
            String definicionV = SolicitarCosas.solicitarStringSinLimite("Introduzca la definición de la palabra");
            gestion.anadirPalabra(palabraK,definicionV);
            System.out.println("La palabra se ha añadido correctamente");
        }
    }

    /**
     * Modifica la definicion de la palabra del diccionario
     */
    public static void modificarPalabra(){
        String palabraK = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que quiera modificar");
        if (gestion.getDefinicion(palabraK) == null){
            System.err.println("La palabra no existe en el diccionario");
        }
        else {
            String definicionV = SolicitarCosas.solicitarStringSinLimite("Introduzca la nueva definición de la palabra");
            gestion.modificarPalabra(palabraK,definicionV);
            System.out.println("La palabra ha sido modificada correctamente");
        }
    }

    /**
     * Borra la palabra del diccionario
     */
    public static void borrarPalabra(){
        String palabraK = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que quiera eliminar");
        if (gestion.eliminarPalabra(palabraK)){
            System.out.println("La palabra se ha eliminado correctamente");
        }
        else {
            System.err.println("La palabra no existe");
        }
    }

    /**
     * Metodo para consultar una palabra
     */
    public static void consultarPalabra(){
        String palabraK = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que quiera consultar");
        String definicionV = gestion.getDefinicion(palabraK);
        if (definicionV != null){
            System.out.println(palabraK + ": "+ definicionV);
        }
        else {
            System.err.println("La palabra no existe en el diccionario");
        }
    }

    /**
     * Metodo para empezar a jugar a adivinar la palabra por la definición
     */
    public static void jugar(){
        if (gestion.getDiccionario().isEmpty()){
            System.err.println("El diccionario está vacío");
            return;
        }
        int puntos = 0;
        boolean sigueJugando = true;

        while (sigueJugando){
            String definicion = gestion.definicionAleatoria();
            System.out.println("La definición es: "+ definicion);
            String respuestaCorrecta = gestion.palabraDesdeLaDefinicion(definicion);
            System.out.println("¿Que palabra palabrita es? | Pista pistosa, empieza por la ["+ respuestaCorrecta.charAt(0)+"]");
            String respuesta = SolicitarCosas.solicitarStringSinLimite("Ponga su respuesta: ");

            if (respuesta.equals(respuestaCorrecta)){
                puntos++;
                System.out.println("Toma jeroma pastillas de goma, has acertado, tu puntuación es de: "+ puntos);
            }else {
                System.out.println("Oooooh, que pena... que pena. La palabra era:  "+ respuestaCorrecta);
                sigueJugando = false;
            }
        }
        System.out.println("El juego se ha acabado. Tu puntuacion final es de: "+puntos);

        if (puntos > 0 && ((gestion.getMejoresPuntuaciones().size() < 5) || (puntos > gestion.getMejoresPuntuaciones().get(gestion.getMejoresPuntuaciones().size() - 1).getPuntos()))){
            System.out.println("Ole! Estas entre los 5 mejores.");
            String nombre = SolicitarCosas.solicitarStringSinLimite("Introduzca su nombre o el nombre con el que quieras guardar la puntuación");
            gestion.anadirPuntuacion(nombre,puntos);
            System.out.println("Puntuación añadida a los tops de los topes");
        }
    }

}
