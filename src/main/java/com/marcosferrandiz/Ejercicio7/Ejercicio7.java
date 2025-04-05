package com.marcosferrandiz.Ejercicio7;

import com.marcosferrandiz.lib.SolicitarCosas;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio7 {
    private static Map<String,Double> tablaConversion = new HashMap<>();
    //Que susto, pense que lo tenia mal probando con pesos argentinos, pero es que mientras escribia el codigo Milei ha hecho cositas y me lo ha cambiado
    public static void main(String[] args) {
        tablaConversion.put("USD",1.11);
        tablaConversion.put("GBP",0.84);
        tablaConversion.put("INR",94.29);
        tablaConversion.put("AUD",1.75);
        tablaConversion.put("CAD",1.56);
        tablaConversion.put("ARS",1188.25);
        tablaConversion.put("BOB",7.64);
        tablaConversion.put("CLP",1055.73);
        tablaConversion.put("VEZ",4592.90);
        tablaConversion.put("CRC",556.90);
        tablaConversion.put("CUP",26.53);
        tablaConversion.put("DOP",69.80);
        tablaConversion.put("MXN",22.07);

        double cantidadDinerosEuros = SolicitarCosas.solicitarDoubleConMinimo("Introduzca la cantidad de unidades de euro que desea convertir",0);
        System.out.println("Introduzca a que moneda quiere convertir sus dineros");
        System.out.println("1.USD | 2.GBP | 3.INR | 4.AUD | 5.CAD | 6.ARS | 7.BOB | 8.CLP | 9.VEZ | 10.CRC | 11.CUP | 12.DOP | 13.MXN");
        int deci = SolicitarCosas.solicitarEntero("Elija la decidion que quiera",1,13);
        String nombreMonedaCambio = devolverDecisionString(deci);
        double valorMonedaCambio = sacarValorMoneda(nombreMonedaCambio);
        System.out.printf("%.2f € = %.2f %s",cantidadDinerosEuros,valorMonedaCambio,nombreMonedaCambio);
    }

    /**
     * Mediante la decision tomada saca el nombre de la moneda (que es la key)
     * @param deci Es la decision de que moneda quieres usar
     * @return Devuelve un String con el nombre de la moneda que es la key
     */
    public static String devolverDecisionString(int deci){
        switch (deci){
            case 1 : return "USD";
            case 2 : return "GBP";
            case 3 : return "INR";
            case 4 : return "AUD";
            case 5 : return "CAD";
            case 6 : return "ARS";
            case 7 : return "BOB";
            case 8 : return "CLP";
            case 9 : return "VEZ";
            case 10 : return "CRC";
            case 11 : return "CUP";
            case 12 : return "DOP";
            case 13 : return "MXN";
            default: return null;
        }
    }

    /**
     * Mediante el nombre de la moneda que es la saca el valor de la moneda y la devuelve mediante double
     * @param nombre Es el nombre key de la moneda, un string
     * @return Devuelve el valor de la moneda en forma double
     */
    public static double sacarValorMoneda(String nombre){
        for (Map.Entry<String,Double> moneda : tablaConversion.entrySet()){
            if (moneda.getKey().equals(nombre)){
                return moneda.getValue();
            }
        }
        return 0;
    }


}
