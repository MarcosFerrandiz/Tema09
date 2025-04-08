package com.marcosferrandiz.Ejercicio10;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Gestion {
    private List<Empleados> empleados;

    public Gestion() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Metodo que mediante el DNI saca el Empleado al que le corresponde
     * @param dni Es el DNI del empleado
     * @return Devuelve el Empleado cuyo DNI es ese
     */
    public Empleados buscarPorDNI(String dni){
        for (Empleados empleado : empleados){
            if (empleado.getDni().equals(dni)){
                return empleado;
            }
        }
        return null;
    }

    /**
     * Agraga un nuevo empleado a la List de empleados
     * @param empleado Le damos el Empleado
     * @return Devolverá true si e ha añadido correctameente y false si ya existe ese empelado
     */
    public boolean agragarEmpleado(Empleados empleado){
        if (buscarPorDNI(empleado.getDni()) != null){
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    /**
     * Se agraga un hijo a un Empleado
     * @param dni Es el DNI del Empleado al que queremos meterle el niño
     * @param hijo Es el Hijo que queremos agragar
     */
    public void agragarHijo(String dni, Hijos hijo){
        Empleados empleado = buscarPorDNI(dni);
        if (empleado != null){
            empleado.agragarHijo(hijo);
        }
    }

    /**
     * Metodo para modificar el sueldo de un Empelado
     * @param dni Es el DNI del Empleado al que queremos modificarle el sueldo
     * @param nuevoSueldo Es el nuevo sueldo que queremos ponerle
     * @return Devolverá true si se ha podido modificar y false si no se a podido
     */
    public boolean modificarSueldo(String dni, double nuevoSueldo){
        Empleados empleado = buscarPorDNI(dni);
        if (empleado != null){
            empleado.setSueldo(nuevoSueldo);
            return true;
        }
        return false;
    }

    /**
     * Metodo que sirve para Eliminar un Empleado del List
     * @param dni Es el DNI del empleado que queremos eliminar
     * @return Devuelve true si se ha podido eliminar el Empleado y false si no
     */
    public boolean eliminarEmpleado(String dni){
        Empleados empleado = buscarPorDNI(dni);
        if (empleado != null){
            empleados.remove(empleado);
            return true;
        }
        return false;
    }

    /**
     * Metodo que sirve para eliminar un hijo a un Empleado
     * @param dni El DNI del Empleado al que queremos eliminarle el hijo
     * @param nombre Es el nombre del Hijo que queremos quitar
     * @return Devuelve true si se ha podido eliminar y false si no
     */
    public boolean eliminarHijo(String dni, String nombre){
        Empleados empleado = buscarPorDNI(dni);
        return empleado != null && empleado.eliminarHijo(nombre);
    }

    /**
     * Metodo que sirve para sacar un List<Empleados> con todos los Empleados con el nombre indicado
     * @param nombre Es el nombre que queremos consultar y sacara en el list
     * @return Devuelve un List<Empleados> con todos los Empleados con el nombre indicado
     */
    public List<Empleados> buscarPorNombre(String nombre){
        List<Empleados> resultadoEmpleados = new ArrayList<>();
        for (Empleados empleado : empleados){
            if (empleado.getNombre().equals(nombre)){
                resultadoEmpleados.add(empleado);
            }
        }
        return resultadoEmpleados;
    }

    /**
     * Metodo para sacar un List<Empleados> cuyos Empleados esten dentro de un rango de edad indicado
     * @param edadMin Es la edad minima de los empleados que queremos sacar
     * @param edadMax Es la edad maxima de los empleados que queremos sacar
     * @return Devuelve un list con todos los empleados dentro del rango
     */
    public List<Empleados> buscarPorRangoDeEdad(int edadMin, int edadMax){
        List<Empleados> resultadoEmpleados = new ArrayList<>();
        for (Empleados empleado : empleados){
            if (empleado.getEdad() > edadMin && empleado.getEdad() < edadMax){
                resultadoEmpleados.add(empleado);
            }
        }
        return resultadoEmpleados;
    }

    /**
     * Metodo que devuelve un List<Empleados> cuyos Empleados estan dentro del rango de sueldo indicado
     * @param sueldoMin Es el sueldo minimo
     * @param sueldoMax Es el sueldo maximo
     * @return Devuelcve un List<Empleados> con los Empleados dentro del rango de sueldo indicado
     */
    public List<Empleados> buscarPorRangoDeSueldo(double sueldoMin, double sueldoMax){
        List<Empleados> resultadoEmpleados = new ArrayList<>();
        for (Empleados empleado : empleados){
            if (empleado.getSueldo() > sueldoMin && empleado.getSueldo() < sueldoMax){
                resultadoEmpleados.add(empleado);
            }
        }
        return resultadoEmpleados;
    }

    /**
     * Metodo que saca un List<Empelados> de los Empelados que tengan Hijos menores
     * @return Devuelve un List<Empleados> con todos los Empleados con Hijos menores
     */
    public List<Empleados> buscarPorHijosMenores(){
        List<Empleados> resultadoEmpleados = new ArrayList<>();
        for (Empleados empleado : empleados){
            if (empleado.tieneHijosMenores()){
                resultadoEmpleados.add(empleado);
            }
        }
        return resultadoEmpleados;
    }




}
