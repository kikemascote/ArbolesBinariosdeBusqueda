package mx.maxa.alumno;

import java.util.Comparator;

public class Alumno implements Comparable<Alumno>, Comparator<Alumno> {
    String nombre=null;
    Double promedio=0.0d;



    public Alumno(){
        nombre="";
        promedio=0d;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public int compareTo(Alumno o) {
        return 0;
    }

    @Override
    public int compare(Alumno o1, Alumno o2) {
        return 0;
    }
    /*
    String nombre=null;
    double promedio = 0.00;
    getters and setters
    compare
    compareTo

    busqueda en profucndidad y recorrido enprofundidad
     */
}
