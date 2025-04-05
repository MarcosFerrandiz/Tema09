package com.marcosferrandiz.Ejercicio5;

public class ManejoPacientes {

    /**
     * Un array de 2 en el cual saca el id del paciente menor en la posicion 0 y en la posicion 1 el mas mayor
     * @param listaPacientes Es un Array de Pacientes del cual queremos saber el paciente mayor y menor
     * @return Devuelve un array de enteros con la id de paciente menor de la lista en la posicion 0 y la del mayor en la posicion 1
     */
    public int[] majorMenor(Pacientes[] listaPacientes){
        int auxEdadMen = 200;
        int auxEdadMaj = 0;
        int idMenor = 0;
        int idMayor = 0;
        int[] arrayIds = new int[2];
        for (Pacientes paciente : listaPacientes){
            if (paciente.getEdad() < auxEdadMen){
                auxEdadMen = paciente.getEdad();
                idMenor = paciente.getId();
            }
            if (paciente.getEdad() > auxEdadMaj){
                auxEdadMaj = paciente.getEdad();
                idMayor = paciente.getId();
            }
        }
        arrayIds[0] = idMenor;
        arrayIds[1] = idMayor;
        return arrayIds;
    }

    /**
     * Cuenta la cantidad de hombres y mujeres y mete en un array de enteros la cantidad de cada uno, siendo la posicion 0 los hombres y el 1 las mujeres
     * @param listaPacientes Es un Array de Pacientes de los que queremos contar
     * @return Devuelve un array de enteros con la cantidad de hombres y mujeres que hay en la lista
     */
    public int[] pacientesPorGenero(Pacientes[] listaPacientes){
        int cantidadHombres = 0;
        int cantidadMujeres = 0;
        int[] arrayCantidades = new int[2];
        for (Pacientes paciente : listaPacientes){
            if (paciente.getGenero() == Genero.M){
                arrayCantidades[0]++;
            }
            else{
                arrayCantidades[1]++;
            }
        }
        return arrayCantidades;
    }

    /**
     * Calcula el IMC de un paciente, devolviendo el IMC que es un double
     * @param paciente Es el paciente que queremos saber su IMC
     * @return Devuelve el IMC del paciente introducido
     */
    public double calcularIMC(Pacientes paciente){
        return paciente.getPeso() / (paciente.getAltura() * paciente.getAltura());
    }

}
