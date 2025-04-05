package com.marcosferrandiz.Ejercicio5;

import com.marcosferrandiz.lib.SolicitarCosas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Ejercicio5 {
    private static ManejoPacientes listaPacientes = new ManejoPacientes();
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Pacientes[] pacientes = new Pacientes[5];
        pacientes[0] = new Pacientes( "Paciente1", LocalDate.parse("12/02/1980",dateTimeFormatter), Genero.F,1.63, 57 );
        pacientes[1] = new Pacientes( "Paciente2", LocalDate.parse("07/03/1990",dateTimeFormatter) , Genero.F,1.74, 60.5);
        pacientes[2] = new Pacientes( "Paciente3",  LocalDate.parse("20/03/1967",dateTimeFormatter), Genero.F,1.62, 50.8);
        pacientes[3] = new Pacientes( "Paciente4", LocalDate.parse( "20/04/1972",dateTimeFormatter) , Genero.M,1.78, 72.5);
        pacientes[4] = new Pacientes( "Paciente5", LocalDate.parse("29/02/1960",dateTimeFormatter) , Genero.M,1.8, 85.2);

        int[] majorMenor = listaPacientes.majorMenor(pacientes);
        int idMayor = majorMenor[1];
        int idMenor = majorMenor[0];

        Pacientes pacienteMenor = null;
        Pacientes pacienteMayor = null;

        for (Pacientes paciente : pacientes){
            if (paciente.getId() == idMenor){
                pacienteMenor = paciente;
            }
            if (paciente.getId() == idMayor){
                pacienteMayor = paciente;
            }
        }

        System.out.println("Paciente MAYOR: "+ pacienteMayor);
        System.out.println("Paciente MENOR: "+ pacienteMenor);

        int[] pacientesGenero = listaPacientes.pacientesPorGenero(pacientes);
        System.out.println("Cantidad de pacientes por sexos:");
        System.out.println("Hombres: "+pacientesGenero[0]+" | Mujeres: "+pacientesGenero[1]);

        for (Pacientes paciente : pacientes) {
            comoDeGordoEstas(paciente);
        }
    }

    /**
     * Metodo que imprime si tienes sobrepeso o no, dependiendo de tu IMC
     * @param paciente Es el paciente el cual queremos ver si tiene sobrepeso
     */
    public static void comoDeGordoEstas(Pacientes paciente){
        System.out.print("El paciente "+ paciente.getId()+": ");
        double imcPaciente = listaPacientes.calcularIMC(paciente);
        if (imcPaciente < 18.5){
            System.out.println("Peso insuficiente");
        } else if (imcPaciente <= 24.9){
            System.out.println("Peso Normal");
        } else if (imcPaciente <= 26.9){
            System.out.println("Sobrepeso grado I");
        }else if (imcPaciente <= 29.9){
            System.out.println("Sobrepeso grado II");
        }else {
            System.out.println("Sobrepeso grado III");
        }
    }

}
