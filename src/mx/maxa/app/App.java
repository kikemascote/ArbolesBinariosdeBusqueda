package mx.maxa.app;

import mx.maxa.alumno.Alumno;
import mx.maxa.btree.btree;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // comienza la medida del taim
        long time_start, time_end;
        time_start = System.currentTimeMillis();

        //termina la medida del taim
        time_end= System.currentTimeMillis();
        System.out.println("\nTiempo para la insercion:"+(time_end-time_start)+"ms");

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
        //termina la medida del taim
        time_end= System.currentTimeMillis();
        System.out.println("\nTiempo para la insercion:"+(time_end-time_start)+"ms");

        btree<String> cadenitas = new btree<>();

        cadenitas.add("ricar2");
        cadenitas.add("Gaby");
        cadenitas.add("Jalilow");
        cadenitas.add("Arturo");
        cadenitas.add("A");
        cadenitas.add("S");
        cadenitas.add("E");

        cadenitas.printInorder();
        //termina la medida del taim
        time_end= System.currentTimeMillis();
        System.out.println("\nTiempo para la insercion:"+(time_end-time_start)+"ms");

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


        btree<Integer> prueba = new btree<>();

        prueba.add(40);
        prueba.add(10);
        prueba.add(20);
        prueba.add(30);
        prueba.add(60);
        prueba.add(50);
        prueba.add(70);
        prueba.add(75);
        prueba.add(22);

        System.out.println("el BFS: ");
        System.out.println(""+prueba.breadthSearch(70));
        System.out.println("preorder:");
        prueba.printPreorder();
        System.out.println("pozole;");
        prueba.printPostOrder();
        System.out.println("inorder");
        prueba.printInorder();
        System.out.println("\nborrando:");
        prueba.clear();
        System.out.println("calando isempty:");
        System.out.println(""+prueba.isEmpty());
        System.out.println(""+prueba.deepSearch(70));
//        System.out.println(""+prueba.isChild(60).getValue()+"\n");


/*
* referencias para resolver el BFS
* https://www.java2blog.com/breadth-first-search-in-java/#Java_BFS_Example
* https://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF
* */

    }
}
