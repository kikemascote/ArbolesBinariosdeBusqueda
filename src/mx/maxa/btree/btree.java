package mx.maxa.btree;

import mx.maxa.node.node;

public class btree<T extends Comparable> implements Comparable<T> {

    private node<T> root    = null;
    private int height      = 0;


    public btree(){
        this.root = new node<>();
    }
    public btree(T value){
        this.root = new node<>(value);
    }

    public void add(T value){
        if (root.getValue()==null)
            root.setValue(value);
        else
            add(value,root);

    }
    private void add(T value, node<T> root){
        if (root.getValue().compareTo(value)>=1){
            if (root.getLeft()==null){
                root.setLeft(new node<>(value));
                return;
            }else {
                add(value,root.getLeft());
            }
        }else if (root.getValue().compareTo(value)<=-1 || root.getValue().compareTo(value)== 0){
            if (root.getRight()==null){
                root.setRight(new node<>(value));
                return;
            }else {
                add(value, root.getRight());
            }
        }
    }
    public boolean remove(T value){
        if (deepSearch(value)!=null)
            return remove(value, root, null);
        else return false;
    }
    private boolean remove(T value, node<T> root, node<T> paps){
        if (isChild(value)==null){
            
        }
    }
    public void printInOrder(node<T> root){
        if (root.getLeft()!=null)
            printInOrder(root.getLeft());

        System.out.println(root.getValue().toString());

        if (root.getRight()!=null)
            printInOrder(root.getRight());
        //System.out.println(root.getValue().toString());
    }

    public node<T> deepSearch(T value){
        return deepSearch(value, root);
    }

    private node<T> deepSearch(T value, node<T> root){
        if (root!=null) {
            if (root.getValue().equals(value))
                return root;
            if (root.getValue().compareTo(value)<=-1) {
                return deepSearch(value, root.getRight());
            } else {
                return deepSearch(value, root.getLeft());
            }
        }else {
            return null;
        }


    }

    public node<T> breadthSearch(){
        return null;
    }

    public void printPreOrder(){

    }
    public void printPostOrder(){

    }
    public node<T> isChild(T value){
        if (deepSearch(value)==null)
            return null;
        return isChild(value, root, null);
    }
    private node<T> isChild(T value, node<T> root, node<T> paps){
        if (root!=null) {
            if (root.getValue().equals(value))
                return paps;
            if (root.getValue().compareTo(value)<=-1) {
                return isChild(value, root.getRight(),root);
            } else {
                return isChild(value, root.getLeft(),root);
            }
        }else {
            return null;
        }
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


    public void printInOrder() {
        printInOrder(root);
    }
}
