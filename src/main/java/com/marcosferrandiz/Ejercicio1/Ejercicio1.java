package com.marcosferrandiz.Ejercicio1;


import com.marcosferrandiz.lib.Aleatorios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        System.err.println(numeros);
        ArrayList<Integer> arrayListOrdenado = arrayOrdenadoParesImpares(numeros);
        System.out.println(arrayListOrdenado);
    }

    public static void generarNumerosAleatorios(int[] numeros){
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i] = Aleatorios.nnumeroAleatorio(0,50);
        }
    }

    public static ArrayList<Integer> arrayOrdenadoParesImpares(int[] num){
        ArrayList<Integer> paresImpares = new ArrayList<>(num.length);
        for (int i = 0; i < num.length ; i++) {
            if (num[i] % 2 == 0){
                paresImpares.add(num[i]);
            }
        }
        for (int i = 0; i < num.length ; i++) {
            if (num[i] % 2 != 0) {
                paresImpares.add(num[i]);
            }
        }
        return paresImpares;
    }

}
