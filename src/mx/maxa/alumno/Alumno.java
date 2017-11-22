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
        if (this.promedio == o.promedio) return 0;
        else if (this.promedio > o.promedio) return 1;
        else
            return -1;
    }

    @Override
    public int compare(Alumno o1, Alumno o2) {

        return o1.compareTo(o2);
    }

    @Override
    public String toString(){
        return promedio+"";
    }
    /*
    String nombre=null;
    double promedio = 0.00;
    getters and setters
    compare
    compareTo

tarea
    busqueda en profundidad y recorrido en profundidad
     */
}
