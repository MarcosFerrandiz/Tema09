package com.marcosferrandiz.Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayListEstadisticas implements IEstadisticas {
    private ArrayList<Double> numeros = new ArrayList<Double>();

    public ArrayListEstadisticas(ArrayList<Double> numeros) {
        this.numeros = numeros;
    }

    @Override
    public double minimo(){
        double aux = numeros.get(0);
        for (int i = 0; i < numeros.size() ; i++) {
            if (aux <= numeros.get(i)){
                aux = numeros.get(i);
            }
        }
        return aux;
    }

    @Override
    public double maximo(){
        double aux = numeros.get(0);
        for (int i = 0; i < numeros.size() ; i++) {
            if (aux >= numeros.get(i)){
                aux = numeros.get(i);
            }
        }
        return aux;
    }

    @Override
    public double sumatorio() {
        double resultado = 0;
        for (int i = 0; i < numeros.size() ; i++) {
            resultado = resultado + numeros.get(i);
        }
        return resultado;
    }

    @Override
    public double media() {
        double resultado = 0;
        for (int i = 0; i < numeros.size() ; i++) {
            resultado = resultado + numeros.get(i);
        }
        return resultado/ numeros.size();
    }

    @Override
    public double moda() {
        Map<Double,Integer> mapaRepeticiones = new HashMap<>();
        for (Double numero : numeros) {
            if (mapaRepeticiones.containsKey(numero)){
                mapaRepeticiones.put(numero, mapaRepeticiones.get(numero)+1);
            }else {
                mapaRepeticiones.put(numero,1);
            }
        }

        double moda = 0;
        int maxRepeticiones = 0;
        for (Map.Entry<Double,Integer> numero : mapaRepeticiones.entrySet()){
            if (numero.getValue() > maxRepeticiones){
                maxRepeticiones = numero.getValue();
                moda = numero.getKey();
            }
        }
        if (maxRepeticiones == 1){
            return 0;
        }
        return moda;
    }
}
