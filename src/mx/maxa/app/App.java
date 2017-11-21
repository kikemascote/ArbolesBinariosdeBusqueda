package mx.maxa.app;

import mx.maxa.btree.btree;

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
        numeritos.add(0);

        numeritos.printInOrder();
    }
}
