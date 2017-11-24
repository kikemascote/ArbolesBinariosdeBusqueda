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
        node<T> tmp = deepSearch(value);
        if (deepSearch(value)!=null)
            return remove(value, tmp, isChild(value));
        else return false;
    }
    private boolean remove(T value, node<T> root, node<T> paps){
        //revisar estooooooo
        node<T> tmp = deepSearch(value);
        System.out.println(tmp.getValue().toString());
        System.out.println(tmp.getLeft().getValue().toString());
        System.out.println(tmp.getRight().getValue().toString());

        if (isChild(value)==null){
            node<T> miNode = minSearch(tmp.getRight());
            miNode.setLeft(tmp.getLeft());
            this.root =tmp.getRight();
            return true;

        }

        if (root.getLeft()== null && root.getRight() == null){
            if (paps.getLeft().equals(root) && paps.getLeft()!=null)
                paps.setLeft(null);
            else if (paps.getRight()!= null)
                paps.setRight(null);
            return true;
        }else if (root.getLeft()!=null && root.getRight()==null){
            if (paps.getLeft().equals(root))
                paps.setLeft(root.getLeft());
            else
                paps.setRight(root.getLeft());
            return true;
        }else if (root.getLeft() == null && root.getRight() != null) {
            if (paps.getLeft().equals(root))
                paps.setLeft(root.getRight());
            else
                paps.setRight(root.getRight());
            return true;
        }else {
            if (paps.getLeft().equals(root)) {
                node<T> left = minSearch(root.getRight());
                left.setLeft(root.getLeft());
                paps.setLeft(root.getRight());
            } else {
                node<T> left = minSearch(root.getRight());
                left.setLeft(root.getLeft());
                paps.setRight(root.getRight());
            }
        }
        return true;
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
    private node<T> minSearch(node<T> root){
        while(root.getLeft()!=null)
            root = root.getLeft();
        return root;
    }
    private node<T> maxSearch(node<T> root){
        while(root.getRight()!=null)
            root = root.getRight();
        return root;
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
