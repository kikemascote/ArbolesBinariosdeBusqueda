package mx.maxa.btree;

import mx.maxa.node.node;

public class btree<T> implements Comparable<T> {

    private node<T> root    = null;
    private int height      = 0;


    public btree(){
        this.root = new node<>();
    }
    public btree(T value){
        this.root = new node<>(value);
    }

    public void add(T value){

    }
    public boolean remove(T value){
        return false;
    }
    public void printInOrder(){

    }
    public void printPreOrder(){

    }
    public void printPostOrder(){

    }
    private void isChild(T value){

    }
    private boolean isEmpty(){

        return false;
    }
    private node<T> search(T value){

        return null;
    }
    private node<T> minSearch(){

        return null;
    }
    private node<T> maxSearch(){

        return null;
    }
    private int maxDepth(){

        return 0;
    }
    private void clear(){

    }
    private boolean exists(T value){
        return false;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }


}
