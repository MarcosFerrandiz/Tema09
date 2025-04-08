package com.marcosferrandiz.Ejercicio9;

import java.util.List;
import java.util.Map;

public class Vista {
    /**
     * Menu bueno bonito y barato
     */
    public static void mostrarMenu(){
        System.out.println("***********************");
        System.out.println("* GESTIÓN DICCIONARIO *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("6. Jugar");
        System.out.println("7. Mejores puntuaciones");
        System.out.println("-----------------------");
        System.out.println("0. Salir");
    }

    /**
     * Muestra el diccionario al completo con la palabra y la definición al lado
     * @param diccionarioMap Es el diccionario que queremos mostrar
     */
    public static void mostrarDiccionario(Map<String,String> diccionarioMap){
        if (diccionarioMap.isEmpty()){
            System.out.println("El diccionario está completamente vacío");
        }
        else {
            System.out.println("Tremendo diccionario:");
            for (Map.Entry<String,String> palabra : diccionarioMap.entrySet()){
                System.out.println(palabra.getKey()+": "+ palabra.getValue());
            }
        }
    }

    /**
     * Muestra las mejores puntuaciones de un List
     * @param puntuacion Es el List de las puntuaciones que queremos mostrar
     */
    public static void mostrarTopPuntuaciones(List<Puntuacion> puntuacion){
        if (puntuacion.isEmpty()){
            System.out.println("No hay puntuaciones en el top");
        }
        else {
            System.out.println("Mejores puntuaciones hasta la fecha:");
            int posicion = 1;
            for (Puntuacion puntos : puntuacion){
                System.out.println(posicion+". "+ puntos.getNombre() + ": "+ puntos.getPuntos());
                posicion++;
            }
        }
    }
}
