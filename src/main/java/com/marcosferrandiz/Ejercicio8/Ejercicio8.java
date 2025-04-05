package com.marcosferrandiz.Ejercicio8;

import com.marcosferrandiz.lib.SolicitarCosas;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio8 {
    private static Map<String,String> diccionario = new HashMap<>();
    public static void main(String[] args) {
        int deci;
        do {
            deci = mostrarMenu();
            switch (deci){
                case 1 -> anadirPalabra();
                case 2 ->{
                    String palabraModificar = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que desea modificar");
                    modificarPalabra(palabraModificar);
                }
                case 3 ->{
                    String palabraBorrar = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que desea eliminar");
                    boolean sePuede = eliminarPalabra(palabraBorrar);
                    if (sePuede){
                        System.out.println("La palabra se ha eliminado correctamente");
                    } else {
                        System.err.println("No se puede borrar la palabra porque no existe");
                    }
                }
                case 4 -> {
                    String palabraConsular = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra a consultar");
                    System.out.println(consultarPalabra(palabraConsular));
                }
                case 5 -> mostrarDiccionario();
                default ->{
                    System.out.println("Saliendo...");
                }
            }
        }while (deci != 0);
    }

    /**
     * Menu 👍
     * @return Devuelve la decisión tomada por el usuario
     */
    public static int mostrarMenu(){
        System.out.println("***********************");
        System.out.println("* GESTIÓN DICCIONARIO *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("-----------------------");
        System.out.println("0. Salir");
        return SolicitarCosas.solicitarEntero("¿Que desa hacer?",0,5);
    }

    /**
     * Añade palabra al diccionario
     */
    public static void anadirPalabra(){
        boolean check;
        do {
            check = false;
            String palabraAnadir = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra que quiera añadir");
            for (Map.Entry<String,String> palabra : diccionario.entrySet()){
                if (palabra.getKey().equals(palabraAnadir)){
                    check = true;
                    break;
                }
            }
            if (check){
                System.err.println("La palabra que quieres introducir ya existe, pruebe otra vez");
                check = false;
            } else {
                String definicion = SolicitarCosas.solicitarStringSinLimite("Introduzca la definición de la palabra");
                diccionario.put(palabraAnadir,definicion);
                check = true;
                System.out.println("La palabra se a introducido correctamente");
            }
        }while (!check);
    }

    /**
     * Elimina la palabra que indique el usuario en el caso de que lo encuetre
     * @param palabraBorrar Es la palabra que quiere eliminar
     * @return Devuelve true si se elimina correctamente y false si no se elimina
     */
    public static boolean eliminarPalabra(String palabraBorrar){
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            if (palabra.getKey().equals(palabraBorrar)){
                diccionario.remove(palabra.getKey());
                return true;
            }
        }
        return false;
    }

    /**
     * Modifica la definicion de la palabra que se le indique y solicitara la nueva definicion
     * @param palabraModificar Es la palabra que quiere modificar la definicion
     * @return Devuelve true en el caso de que se haya modificado correctamente y false si no se ha modificado
     */
    public static boolean modificarPalabra(String palabraModificar){
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            if (palabra.getKey().equals(palabraModificar)){
                String nuevaDifinicion = SolicitarCosas.solicitarStringSinLimite("Introduzca la nueva definición de la palabra");
                diccionario.replace(palabraModificar,palabra.getValue(),nuevaDifinicion);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que mediante una palabra te da la definicion, en el caso de que la palabra no este saldra un mensaje de que no se encuentra
     * @param palabraConsultar Es la palabra que quiere consultar para saber la definicion
     * @return Devuelve la definicion de la palabra, en el caso de que no la encuentre devulvera de que no se encuentra
     */
    public static String consultarPalabra(String palabraConsultar){
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            if (palabra.getKey().equals(palabraConsultar)){
                return palabra.getValue();
            }
        }
        return "La palabra no se a encontrado la palabra"+palabraConsultar;
    }

    /**
     * Metodo que muestra todas las paalbras del map diccionario con sus definiciones
     */
    public static void mostrarDiccionario(){
        int contador = 0;
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            contador++;
            System.out.println("-----------------------------");
            System.out.println("Palabra "+ contador);
            System.out.println(palabra.getKey()+": ");
            System.out.println(palabra.getValue());
        }
    }


}
