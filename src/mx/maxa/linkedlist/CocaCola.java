package mx.maxa.linkedlist;

import mx.maxa.node.node;



public interface CocaCola<T> {
    public void enQueue(T value) throws ColaFullEx;
    public T deQueue() throws ColaEmptyEx;
    public T front() throws ColaEmptyEx;
    public node<T> Search(T value) throws ColaEmptyEx;
    public void clear();
    public int size();
    public boolean isEmpty();
    public boolean isFull();
}
