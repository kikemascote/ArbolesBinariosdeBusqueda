package mx.maxa.linkedlist;

import mx.maxa.node.node;
import java.util.Iterator;


public class DoubleLinkedList<T> implements Iterator<T> {

        private node<T> start = null, end = null,auxIt=null;

        public DoubleLinkedList(){
            createList();
        }

        public DoubleLinkedList(T value){
            this();
            start.setRight(new node<T>(value));
            start.getRight().setIndex(0);
            end.setLeft(start.getRight());
        }
        private void createList() {
            start = new node<T>();
            start.setIndex(-1);
            end = new node<T>();
            end.setIndex(-1);
        }
        public void addFirst(T value){
            node<T> tmp = start.getRight();
            start.setRight(new node<T>(value));
            if (tmp == null){
                start.getRight().setIndex(0);
                end.setLeft(start.getRight());
            }
            else{
                start.getRight().setRight(tmp);
                tmp.setLeft(start.getRight());
            }
            reindex();
        }

        public void addLast(T value){
            node<T> tmp = end.getLeft();
            end.setLeft(new node<T>(value));
            if (tmp == null){
                end.getLeft().setIndex(0);
                start.setRight(end.getLeft());
            }
            else{
                end.getLeft().setLeft(tmp);
                tmp.setRight(end.getLeft());
            }
            reindex();
        }

        public void addAfter(T value, T newValue) {
            node<T> found = search(value);
            if (found!=null) {
                node<T> _new=new node<T>(newValue);
                if (found.getRight() != null) {
                    found.getRight().setLeft(_new);
                    _new.setLeft(found);
                    _new.setRight(found.getRight());
                    found.setRight(_new);
                }else {
                    end.setLeft(_new);
                    _new.setLeft(found);
                    found.setRight(_new);
                }
                reindex();
            }
        }

        public void addBefore(T value,T newValue) {
            node<T> found = search(value);
            if (found!=null) {
                node<T> _new=new node<T>(newValue);
                if (found.getLeft() != null) {
                    found.getLeft().setRight(_new);
                    _new.setRight(found);
                    _new.setLeft(found.getLeft());
                    found.setLeft(_new);
                }else {
                    start.setRight(_new);
                    _new.setRight(found);
                    found.setLeft(_new);
                }
                reindex();
            }
        }

        public node<T> search (T value){
            return search (value, start,end);
        }
        private node<T> search (T value, node<T> start,node<T> end){
            if (!isEmpty()) {
                if(start.getRight().getValue().equals(value)){
                    return start.getRight();
                }else if(end.getLeft().getValue().equals(value)) {
                    return end.getLeft();
                }else if (start.getRight().equals(end) && end.getLeft().equals(start)) {
                    return null;
                }
                return search(value, start.getRight(),end.getLeft());
            }
            return null;

        }

        private void reindex(){
            node<T> tmp = start;
            int i = 0;
            while (tmp.getRight()!=null) {
                tmp = tmp.getRight();
                tmp.setIndex(i);
                i++;
            }
        }

        public void pronter() {
            node<T> tmp = start;
            while (tmp.getRight()!=null) {
                tmp = tmp.getRight();
                System.out.println(tmp.getIndex()+" "+tmp.getValue());
            }
        }

        public void prenter() {
            node<T> tmp = end;
            while (tmp.getLeft()!=null) {
                tmp = tmp.getLeft();
                System.out.println(tmp.getIndex()+" "+tmp.getValue());
            }
        }
        public boolean isEmpty() {
            return (start.getRight()!=null && end.getLeft()!=null)?false:true;
        }

        public int size() {
            node<T> tmp = this.start;
            int cont = 0;
            while (tmp.getRight() != null) {
                cont++;
                tmp = tmp.getRight();
            }
            return cont;
        }

        public long indexOf(T value) {
            node<T> found = search(value);
            if (found != null) {
                return found.getIndex();
            }
            return -1;
        }

        public void replace(T value,T newValue) {
            node<T> found=search( value);
            found.setValue(newValue);
        }

        public void remove(T value) {
            node<T> found = search(value);
            if (found != null) {
                found.getLeft().setRight(found.getRight());
                found.getRight().setLeft(found.getLeft());
                System.gc();
                reindex();
            }
        }

        public void removeAfter(T value) {
            node<T> found = search(value);
            if (found != null) {
                if(found.getRight() != null) {
                    if (found.getRight().getRight() != null) {
                        found.getRight().getRight().setLeft(found);
                        found.setRight(found.getRight().getRight());
                    }else {
                        end.setLeft(found);
                        found.setRight(null);
                    }
                    System.gc();
                    reindex();
                }else {
                    System.out.println("No se puede eliminar despues de " + value + " porque" + value + " es el ultimo valor");
                }
            }
        }

        public void removeBefore(T value) {
            node<T> found = search(value);
            if (found!=null) {
                if (found.getLeft() != null) {
                    if (found.getLeft().getLeft() != null) {
                        found.getLeft().getLeft().setRight(found);
                        found.setLeft(found.getLeft().getLeft());
                    }else {
                        start.setRight(found);
                        found.setLeft(null);
                    }
                    System.gc();
                    reindex();
                }else {
                    System.out.println("No se puede eliminar antes de " + value + " porque" + value + " es el primer valor");
                }
            }
        }

        public void removeFirst() {
            node<T> first=getFist();
            if (first!=null) {
                start.setRight(first.getRight());
                first.getRight().setLeft(null);
                System.gc();
                reindex();
            }
        }

        public void removeLast() {
            node<T> last= getLast();
            if (last!=null) {
                end.setLeft(last.getLeft());
                last.getLeft().setRight(null);
            }
        }

        public node<T> getFist(){
            if(!isEmpty())
                return start.getRight();

            return null;
        }

        public node<T> getLast(){
            if (!isEmpty())
                return end.getLeft();

            return null;
        }

        public void clear() {
            start = null;
            end = null;
            System.gc();
            createList();
        }

        public void list() {
            auxIt=start;
            if (!isEmpty()) {
                while(hasNext()) {
                    System.out.println(next());
                }
            }
        }

        @Override
        public boolean hasNext() {
            return auxIt.getRight()!=null;
        }

        @Override
        public T next() {
            T value = auxIt.getRight().getValue();
            auxIt=auxIt.getRight();
            return value;
        }
}
