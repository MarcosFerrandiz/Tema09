package com.marcosferrandiz.Ejercicio9;

import com.marcosferrandiz.lib.Aleatorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gestion {
    private Map<String,String> diccionario;
    List<Puntuacion> mejoresPuntuaciones;

    public Gestion() {
        diccionario = new HashMap<>();
        mejoresPuntuaciones = new ArrayList<>();
    }

    /**
     * Metodo para añadir una palabra al diccionario
     * @param palabraK Es la palabra principal/clave que se va a añadir
     * @param definicionV Es la definicion de la palabra que se quiere añadir
     * @return Devolvera true si se ha añadido correctamente y false si no se puede añadir
     */
    public boolean anadirPalabra(String palabraK, String definicionV){
        if (diccionario.containsKey(palabraK)){
            return false;
        }
        diccionario.put(palabraK,definicionV);
        return true;
    }

    /**
     * Metodo que sirve para modificar la definición de la palabra
     * @param palabraK Es la palabra la cual queremos modificar la definicion
     * @param definicionV Es la nueva definicion que queremos ponerle a la palabra
     * @return Devuelve true si se ha podido cambiar y false si no se ha podido porque no existe
     */
    public boolean modificarPalabra(String palabraK, String definicionV){
        if (!diccionario.containsKey(palabraK)){
            return false;
        }
        return true;
    }

    /**
     * Elimina la palabra indicada del diccionario
     * @param palabraK Es la palabra que queremos eliminar
     * @return Devuelve true si se ha podido eliminar y false si no se ha podido modificar porque no existe la palabra
     */
    public boolean eliminarPalabra(String palabraK){
        if (!diccionario.containsKey(palabraK)){
            return false;
        }
        diccionario.remove(palabraK);
        return true;
    }

    /**
     * Devuelve la definición de la palabra indicada
     * @param palabraK Es la palabra la cual queremos saber la definición
     * @return Devuelve la definicion en formato String de la palabra indicada
     */
    public String getDefinicion(String palabraK){
        return diccionario.get(palabraK);
    }

    /**
     * Devuelve el diccionario.
     * @return Devuelve el diccionario en formato Map<String,String>
     */
    public Map<String,String> getDiccionario(){
        return diccionario;
    }

    /**
     * Metodo que devuelve una definicion aleatoria del diccionario
     * @return Devuelve una definicion aleatoria en forma de String
     */
    public String definicionAleatoria(){
        if (diccionario.isEmpty()){
            return null;
        }
        List<String> definiciones = new ArrayList<>(diccionario.values());
        return definiciones.get(Aleatorios.aleatorio(0,definiciones.size()));
    }

    /**
     * Metodo que devuelve la palabra clave(Key) desde una definicion(Value)
     * @param definicion Es la definicion de la cual queremos sacar la palabra
     * @return Devuelve un String con la palabra del significado de la definicion
     */
    public String palabraDesdeLaDefinicion(String definicion){
        for (Map.Entry<String,String> palabra : diccionario.entrySet()){
            if (palabra.getValue().equals(definicion)){
                return palabra.getKey();
            }
        }
        return null;
    }

    /**
     * Metodo que añade la puntuacion al List con el nombre y sus puntos
     * @param nombre Es el nombre del jugador con el que se guardarán los puntos
     * @param puntos Son los puntos que ha hecho el jugador
     */
    public void anadirPuntuacion(String nombre, int puntos){
        mejoresPuntuaciones.add(new Puntuacion(nombre,puntos));
        mejoresPuntuaciones.sort((s1,s2) -> s2.getPuntos() - s1.getPuntos());
        if (mejoresPuntuaciones.size() > 5){
            mejoresPuntuaciones.remove(5);
        }
    }

    /**
     * Metodo que devuelve el List de las mejores puntuaciones guardadas
     * @return Devuelve el List de las mejores puntuaciones
     */
    public List<Puntuacion> getMejoresPuntuaciones(){
        return mejoresPuntuaciones;
    }

}
