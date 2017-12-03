package mx.maxa.btree;

import mx.maxa.linkedlist.Cola;
import mx.maxa.linkedlist.ColaFullEx;
import mx.maxa.node.node;

public class btree<T extends Comparable<T>> implements Comparable<T> {
    private node<T> root;
    private int height = 0, count = 0, size = 0;
    private Cola<node<T>> nodeCola;

    public btree() {
        this.root = new node<>();
    }

    public btree(T value) {
        this.root = new node<>(value);
        size++;
    }

    public void add(T value) {
        if (root.getValue() == null)
            root.setValue(value);
        else {
            add(value, root);
            count = 0;
        }
        if (count > height)
            height = count;
        size++;
    }

    private void add(T value, node<T> root) {
        count++;
        if (root.getValue().compareTo(value) >= 1) {
            if (root.getLeft() == null) {
                root.setLeft(new node<>(value));
                return;
            } else
                add(value, root.getLeft());
        } else if (root.getValue().compareTo(value) <= -1
                || root.getValue().compareTo(value) == 0) {
            if (root.getRight() == null) {
                root.setRight(new node<>(value));
                return;
            } else
                add(value, root.getRight());
        }
    }

    public boolean remove(T value) {
        node<T> tmp = deepSearch(value); //si lo encontro
        if (tmp != null)
            return remove(value, tmp, isChild(value));
        return false;
    }

    private boolean remove(T value, node<T> root, node<T> imyourfather) {

        if (isChild(value) == null) {
            node<T> miNode = minSearch(root.getRight());
            miNode.setLeft(root.getLeft());
            this.root = root.getRight();
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            if (imyourfather.getLeft() != null && imyourfather.getLeft().equals(root))
                imyourfather.setLeft(null);
            else if (imyourfather.getRight() != null)
                imyourfather.setRight(null);
            return true;
        } else if (root.getLeft() != null && root.getRight() == null) {
            if (imyourfather.getLeft().equals(root))
                imyourfather.setLeft(root.getLeft());
            else
                imyourfather.setRight(root.getLeft());
            return true;
        } else if (root.getLeft() == null && root.getRight() != null) {
            if (imyourfather.getLeft().equals(root))
                imyourfather.setLeft(root.getRight());
            else
                imyourfather.setRight(root.getRight());
            return true;
        } else {
            if (imyourfather.getLeft().equals(root)) {
                node<T> left = minSearch(root.getRight());
                left.setLeft(root.getLeft());
                imyourfather.setLeft(root.getRight());
            } else {
                node<T> left = minSearch(root.getRight());
                left.setLeft(root.getLeft());
                imyourfather.setRight(root.getRight());
            }
            return true;
        }

    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(node<T> root) {
        if (root.getLeft() != null)
            printInorder(root.getLeft());
        System.out.print(" " + root.getValue().toString());
        if (root.getRight() != null)
            printInorder(root.getRight());
    }

    public void printPreorder() {
        printPreorder(root);
    }

    public void printPreorder(node<T> root) {
        System.out.println("" + root.getValue().toString());
        if (root.getLeft() != null)
            printPreorder(root.getLeft());
        if (root.getRight() != null)
            printPreorder(root.getRight());
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(node<T> root) {
        if (root.getLeft() != null)
            printPostOrder(root.getLeft());
        if (root.getRight() != null)
            printPostOrder(root.getRight());
        System.out.println("" + root.getValue().toString());
    }

    public node<T> isChild(T value) {
        if (deepSearch(value) == null)
            return null;
        return isChild(value, root, null);
    }

    private node<T> isChild(T value, node<T> root, node<T> imyourfather) {
        if (root != null) {
            if (root.getValue().equals(value))
                return imyourfather;
            if (root.getValue().compareTo(value) <= -1)
                return isChild(value, root.getRight(), root);
            else
                return isChild(value, root.getLeft(), root);
        } else
            return null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public node<T> deepSearch(T value) {
        return deepSearch(value, root);
    }

    private node<T> deepSearch(T value, node<T> root) {
        if (root != null) {
            if (root.getValue().equals(value))
                return root;
            if (root.getValue().compareTo(value) <= -1)
                return deepSearch(value, root.getRight());
            else
                return deepSearch(value, root.getLeft());
        } else
            return null;
    }

    public node<T> breadthSearch(T value) {
        //node<T> queue;
        //DoubleLinkedList<T> lista;
        int haltura = height(root);
        nodeCola = new Cola<>(size);
        for (int i = 1; i < haltura; i++) {
            breadthSearch(root, i);

        }
        return null;
    }

    private void breadthSearch(node<T> root, int depth) {
        if (root == null)
            return;
        if (depth == 1) {
            try {
                nodeCola.enQueue(root);
            } catch (ColaFullEx colaFullEx) {
                colaFullEx.printStackTrace();
            }
        } else if (depth > 1) {
            breadthSearch(root.getLeft(), depth - 1);
            breadthSearch(root.getRight(), depth - 1);
        }
    }

    private int height(node<T> root) {
        if (root == null)
            return 0;
        else {
            int lefth = height(root.getLeft());
            int righth = height(root.getRight());

            if (lefth > righth)
                return (lefth + 1);
            else return (righth + 1);
        }
    }

    public node<T> minSearch(node<T> root) {
        while (root.getLeft() != null)
            root = root.getLeft();
        return root;
    }

    public node<T> maxSearch(node<T> root) {
        while (root.getRight() != null)
            root = root.getRight();
        return root;
    }

    public int maxDepth() {
        int count = 0;
        count=(height(root)-1);
        return count;
    }

    public void clear() {
        root.getRight().setRight(null);
        root.getRight().setLeft(null);
        root.getLeft().setRight(null);
        root.getLeft().setLeft(null);
        root.setLeft(null);
        root.setRight(null);
        this.root = null;
        System.gc();
    }

    private boolean exists(T value) {
        return deepSearch(value).equals(value);
    }

    public boolean clearTree() {
        this.root = null;
        System.gc();
        return true;
    }

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        return 0;
    }

}





