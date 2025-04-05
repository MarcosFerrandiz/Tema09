package com.marcosferrandiz.Ejercicio6;

import com.marcosferrandiz.lib.SolicitarCosas;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio6 {
    private static Map<String,String> diccionario = new HashMap<>();
    public static void main(String[] args) {
        int deci;
        do {
            deci = menuPrincipal();
            switch (deci){
                case 1->{
                    introducirPalabras();
                }
                case 2 ->{
                    System.out.println(traducirPalabra(SolicitarCosas.solicitarStringSinLimite("Palabra a buscar: ")));
                }
                default -> {
                    System.out.println("Saliendo...");
                }
            }
        }while (deci != 0);
    }

    /**
     * Menu principal 👍
     * @return Devuelve la decision
     */
    public static int menuPrincipal(){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Introducir parejas de palabras");
        System.out.println("2. Traducir palabras");
        System.out.println("0. Salir de la aplicación");
        int deci = SolicitarCosas.solicitarEntero("Elige una opción: ",0,2);
        return deci;
    }

    /**
     * Metodo para introducir palabras con su traduccion al valenciano a nuestro map que es el diccionario
     */
    public static void introducirPalabras(){
        int cantidad = SolicitarCosas.solicitarInt("¿Cuántas parejas deseas introducir?",0);
        boolean check;
        for (int i = 0; i < cantidad ; i++) {
            do {
                check = false;
                String palabraAnadir = SolicitarCosas.solicitarStringSinLimite("Introduzca la palabra en ingles que quiera añadir");
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
                    String traducción = SolicitarCosas.solicitarStringSinLimite("Introduzca la traducción al valenciano");
                    diccionario.put(palabraAnadir,traducción);
                    check = true;
                    System.out.println("La palabra se ah introducido correctamente");
                }
            }while (!check);
        }
    }

    /**
     * Metodo que te traduce una palabra del ingles al valenciano
     * @param key Es la palabra que queremos traducir que es la key del map
     * @return Devuelve la palabra traducida al valenciano
     */
    public static String traducirPalabra(String key){
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            if (palabra.getKey().equals(key)){
                return palabra.getValue();
            }
        }
        String nada = "La palabra no existe";
        return nada;
    }

}
