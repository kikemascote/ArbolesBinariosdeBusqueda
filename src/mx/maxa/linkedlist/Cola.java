package mx.maxa.linkedlist;

import mx.maxa.node.node;

import java.util.Iterator;

public class Cola<T> implements CocaCola<T>, Iterable<T>, Iterator {
    public node<T> back, front;
    public int count = 0, size = 10;
    private node<T> start = null;
    private node<T> end = null;

    public Cola() {
        start = new node<>();
        end = new node<>();
        node<T> nodo = new node<>();
        start.setIndex(-1);
        end.setIndex(-1);
        node<T> tmp = start.getNext();
        start.setNext(nodo);
        nodo.setBack(start);
        while (count < size) {
            node<T> _new = new node<>();
            tmp.setNext(_new);
            _new.setBack(tmp);
            tmp = tmp.getNext();
            count += 1;
        }
        end.setBack(tmp);
        reindex();
        front = start.getNext();
        back = start.getNext();
    }

    public Cola(int size) {
        count = 0;
        this.size = size;
        start = new node<>();
        start.setIndex(-1);
        end = new node<>();
        end.setIndex(-1);
        node<T> nodo = new node<>();
        start.setNext(nodo);
        nodo.setBack(start);
        node<T> tmp = start.getNext();
        while (count < size) {
            node<T> _new = new node<>();
            tmp.setNext(_new);
            _new.setBack(tmp);
            tmp = tmp.getNext();
            count += 1;
        }
        end.setBack(tmp);
        reindex();
        front = start.getNext();
        back = start.getNext();
        count = 0;
    }


    private void reindex() {
        node<T> tmp = start;
        int i = 0;
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
            tmp.setIndex(i);
            i++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node<T> tmp = back.getBack();
            int i = 0;

            @Override
            public boolean hasNext() {
                if (tmp.getNext() == null)
                    tmp = start.getNext();
                else
                    tmp = tmp.getNext();
                return i++ != count;
            }

            @Override
            public T next() {
                return tmp.getValue();
            }
        };
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void enQueue(T value) throws ColaFullEx {
        if (isFull()) throw new ColaFullEx("Trai la cajuela llena pariente!");
        front.setValue(value);
        count++;
        if (front.getNext() == null)
            front = start.getNext();
        else
            front = front.getNext();
    }

    @Override
    public T deQueue() throws ColaEmptyEx {
        if(isEmpty()) throw new ColaEmptyEx("La cola está vacía");
        T tmp=back.getValue();
        back.setValue(null);
        count--;
        if(back.getNext() == null)
            back = start.getNext();
        else
            back = back.getNext();
        return tmp;
    }

    @Override
    public T front() throws ColaEmptyEx {
        if (isEmpty()) throw new ColaEmptyEx("La cola esta vaciada viejon");
        return back.getValue();
    }

    @Override
    public node<T> Search(T value) throws ColaEmptyEx {
        if (isEmpty()) throw new ColaEmptyEx("primero echele algo primon!");
        node<T> tmp = back;
        for (int i=0;i<=count;i++){
            if (tmp.getValue().equals(value))
                return tmp;
            if (tmp.getNext() != null)
                tmp = tmp.getNext();
            else
                tmp = start.getNext();
        }
        return null;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            try {
                deQueue();
            } catch (ColaEmptyEx colaEmptyEx) {
                colaEmptyEx.printStackTrace();
            }
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public boolean isFull() {
        return count==size;
    }
}
