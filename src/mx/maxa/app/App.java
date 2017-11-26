package mx.maxa.app;

import mx.maxa.alumno.Alumno;
import mx.maxa.btree.btree;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        btree<Integer> numeritos = new btree<Integer>();
        numeritos.add(5);
        numeritos.add(-1);
        numeritos.add(0);
        numeritos.add(24);
        numeritos.add(-6);
        numeritos.add(5);
        numeritos.add(9);
        numeritos.add(-1);
        //numeritos.add(0);
        numeritos.remove(24);
        //while (numeritos.remove(5));

        /*for (int i=0; i<10000; i++){
            numeritos.add((int)(Math.random()*1000000)+1);
        }*/

        numeritos.printInorder();

//        btree<String> cadenitas = new btree<>();
//
//        cadenitas.add("ricar2");
//        cadenitas.add("Gaby");
//        cadenitas.add("Jalilow");
//        cadenitas.add("Arturo");
//        cadenitas.add("A");
//        cadenitas.add("S");
//        cadenitas.add("E");

        //cadenitas.printInOrder();

//        btree<Double> doblesitos = new btree<>();
//        doblesitos.add(2.3);
//        doblesitos.add(3.2);
//        doblesitos.add(5.1);
//        //doblesitos.printInOrder();
//        System.out.println("Encontrando a 3.2: "+doblesitos.deepSearch(3.2d).toString());
//
//
//        //System.out.println("paps: "+doblesitos.isChild(2.3d).toString());
//
        btree<Alumno> alumnos = new btree<>();


    }
}
